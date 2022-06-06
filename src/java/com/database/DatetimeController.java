package com.database;

import com.database.util.JsfUtil;
import com.database.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("datetimeController")
@SessionScoped
public class DatetimeController implements Serializable {

    @EJB
    private com.database.DatetimeFacade ejbFacade;
    private List<Datetime> items = null;
    private Datetime selected;

    public DatetimeController() {
    }

    public Datetime getSelected() {
        return selected;
    }

    public void setSelected(Datetime selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DatetimeFacade getFacade() {
        return ejbFacade;
    }

    public Datetime prepareCreate() {
        selected = new Datetime();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        Date d= new Date(); 
        //Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Europe/Madrid"));
        //Date d = cal.getTime();
        
        this.selected.setCurrentdate(d);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DatetimeCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DatetimeUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DatetimeDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Datetime> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public Datetime getDatetime(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Datetime> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Datetime> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Datetime.class)
    public static class DatetimeControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DatetimeController controller = (DatetimeController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "datetimeController");
            return controller.getDatetime(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof Datetime) {
                Datetime o = (Datetime) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Datetime.class.getName()});
                return null;
            }
        }

    }
       public String computeDiffinminutes(Date date1, Date date2) {
        //Map<TimeUnit,Long> 
         long diffInMillies = date1.getTime()-date2.getTime();
         long intMillis = diffInMillies;
         long dd = TimeUnit.MILLISECONDS.toDays(intMillis);
         intMillis -= TimeUnit.DAYS.toMillis(dd);
         long hh = TimeUnit.MILLISECONDS.toHours(intMillis);
         intMillis -= TimeUnit.HOURS.toMillis(hh);
         long mm = TimeUnit.MILLISECONDS.toMinutes(intMillis);
         intMillis -= TimeUnit.MINUTES.toMillis(mm);
         long ss = TimeUnit.MILLISECONDS.toSeconds(intMillis);
        intMillis -= TimeUnit.SECONDS.toMillis(ss);


         String stringInterval = "%02d days - %02d:%02d:%02d";
         return String.format(stringInterval , dd, hh, mm,ss, intMillis);
 
  }

}
