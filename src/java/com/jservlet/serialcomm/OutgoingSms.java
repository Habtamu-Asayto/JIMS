package com.jservlet.serialcomm;


import java.util.Calendar;
import static com.jservlet.serialcomm.SMSINITIALIZE.Day_One_Msg;

import static com.jservlet.serialcomm.SMSINITIALIZE.Registration_Message;

import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static com.jservlet.serialcomm.Sms.outgoing;



public class OutgoingSms 
{
    
   public final int SMS_MSG_ENCODING_7BIT = 0;

    private int    smscAddressLength= 0x00;
    private int    smscAddressType = 0x91;
    public String smscAddress;
    private String smscAddressEnc;
    private int    smsSubmitCode = 0x11; // 0x11;
    private int    tpMsgRef = 0;
    private int    recipientAddressLength;
    private int    recipientAddressType = 0x91;
    public String recipientAddress;
    private String recipientAddressEnc;
    public int    tpPid;
    public int    tpDcs;
    private int    tpValidity = 0xaa;
    private int    tpUdl;      // message length.
    private String tpUd;       // user message (as sent).
    public String msg;        // user message (unencoded).

    private String pdu;
    String ucsencodedmessage;

    public OutgoingSms(String recipientAddress, String smscAddress, String msg, int tpPid, int tpDcs) 
    {
        
        String ucs2encded;
    	this.recipientAddress = recipientAddress;
        this.smscAddress= smscAddress;
        this.msg = msg;
        ucsencodedmessage=msg;
        this.tpPid = tpPid;
        this.tpDcs = tpDcs;
        StringBuffer sb = new StringBuffer(320);
        smscAddressLength = smscAddress.length();

        // Internal smsc Adress settings taken from mobile
        // if other add smscAddress and smscAddressType to sb.
      
        if(smscAddressLength == 0) 
        {
        	sb.append("00");   // Optional, some mobile don't work if added
        }
        else  
        {
      
            // add smscAddress and smscAddressType to sb.
            try{
         System.out.println("before pduCodec");
            sb.append(PduCodec.toHexString(0x07));
            System.out.println("After pduCodec");
            if( (smscAddressLength%2) == 1 )
            	smscAddressEnc = PduCodec.swapDigits(smscAddress+"F");
            else
            	smscAddressEnc = PduCodec.swapDigits(smscAddress);
 
            sb.append(PduCodec.toHexString(smscAddressType));
            sb.append(smscAddressEnc);
            }
            
            catch(Exception e){System.out.println("here is to hexa codec "+e.getMessage());}
        }

        sb.append(PduCodec.toHexString(smsSubmitCode)); 
		sb.append(PduCodec.toHexString(tpMsgRef)); //tpMsgRef
	
		// recipientAddress
		recipientAddressLength = recipientAddress.length();
		if ((recipientAddress.length() % 2) == 1 )
		    recipientAddressEnc = PduCodec.swapDigits(recipientAddress+"F");
		else
		    recipientAddressEnc = PduCodec.swapDigits(recipientAddress);
	
		sb.append(PduCodec.toHexString(recipientAddressLength));
		sb.append(PduCodec.toHexString(recipientAddressType));
		sb.append(recipientAddressEnc);
		sb.append(PduCodec.toHexString(tpPid));
		sb.append(PduCodec.toHexString(tpDcs));
		sb.append(PduCodec.toHexString(tpValidity));

		// encode message and calculate message length.
	    if ((tpDcs & 4) == 0) 
	    {
                tpUd = PduCodec.sevenBitEncode(msg);
              
                tpUdl = msg.length();
                System.out.println(" The Length  +++++++++++ "+tpUdl);
	    }
	    else 
	    {
	    	tpUd = msg;
	    	tpUdl = msg.length()/2;
	    }
	    
                
                ucs2encded=ucsencode();
		sb.append(PduCodec.toHexString(tpUdl));
		sb.append(tpUd);
		
                pdu = sb.toString();
                String senderdata;
                String lenth;
                
              //String  dpdu="079152911192798011000C915291866312180008AA 1812A512F21218120812350020123512081218132012E81245";
                //----- to be deleted ---
                 pdu=pdu.substring(0, 36) +"0008AA"+"8C"+ucs2encded;
                 System.out.println(" Total PDU  ready to be send ======================>>>.>. "+pdu +"\n");  
                // here is final 
                             
                if ( outgoing == true ){
                   
                    pdu=pdu.substring(0, 36) +"0008AA"+"8C"+ucs2encded;
                  //  System.out.println(" inside outgoing   Total PDU  "+pdu +"\n" +"outgoing "+outgoing);
                    }
              //  System.out.println(" Total PDU  so it is send  "+pdu +"\n");
    }

    public String toString() 
    {
      return pdu.toUpperCase();
    }

	public int length() 
	{
		if ((pdu.substring(0,2)).equals("00")) return (pdu.length()-2)/2;
		else return (pdu.length()-16)/2;
        }


    // Transforms an outgoing to an incoming pdu
    // contains no SMCS
	public void transform_to_received_SMS(Calendar time) 
	{

		int length;
		length=pdu.length();

		// if no SMCS specified, otherwise adaption needed
		int offset1;
		String beginning;
		
		if ((pdu.substring(0,2)).equals("00")) 
		{
			// if transmit without smsc adress enter dummy some smsc address
			beginning="07911497949900F0";
			offset1=6;
		}
		else 
		{
		   beginning=pdu.substring(0,16);
		   offset1=20;
		}
		
		String addressLenStr = pdu.substring(offset1, offset1+2);
		int senderAddressLength = Integer.parseInt(addressLenStr, 16);
		
		int offset2= offset1 + 4 + senderAddressLength+senderAddressLength%2;
		
		String pdu_r=beginning+"04"+pdu.substring(offset1, offset2+4);
		
		//System.out.println(SmsPduCodec.TimeStampEncode(time));
		pdu_r=pdu_r+ PduCodec.TimeStampEncode(time) +pdu.substring(offset2+6,length);
		
		pdu=pdu_r;
	}
        ///// here is configering your daily and weekly messeges 
      public String ucsencode()
        {
            String text = "";
           //  System.out.println(" DAILY MESSEGE====> "+ Dayly_Messege +" I     "+msg);
            if ( msg.equalsIgnoreCase("1") )
                text=Day_One_Msg;
           else if ( msg.equalsIgnoreCase("5") )
       text=Registration_Message;
           // text=Registration_Message;
            else
                 text="";
            try {
                byte[] textByte = text.getBytes("UTF-16BE");
      
   StringBuilder sb = new StringBuilder();
            for (byte b : textByte) {
            sb.append(String.format("%02X ", b));
            }
           
            System.out.println(" the encioded message is =============>"+sb.toString().replaceAll("\\s",""));
     return sb.toString().replaceAll("\\s","");

        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
   
}

}
