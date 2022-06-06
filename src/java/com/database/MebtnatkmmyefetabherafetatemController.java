package com.database;

import com.databse.util.JsfUtil;
import com.databse.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@Named("mebtnatkmmyefetabherafetatemController")
@SessionScoped
public class MebtnatkmmyefetabherafetatemController implements Serializable {

    @EJB
    private com.database.MebtnatkmmyefetabherafetatemFacade ejbFacade;
    private List<Mebtnatkmmyefetabherafetatem> items = null;
    private Mebtnatkmmyefetabherafetatem selected;

    public MebtnatkmmyefetabherafetatemController() {
    }

    public Mebtnatkmmyefetabherafetatem getSelected() {
        return selected;
    }

    public void setSelected(Mebtnatkmmyefetabherafetatem selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private MebtnatkmmyefetabherafetatemFacade getFacade() {
        return ejbFacade;
    }

    public Mebtnatkmmyefetabherafetatem prepareCreate() {
        selected = new Mebtnatkmmyefetabherafetatem();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("MebtnatkmmyefetabherafetatemCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("MebtnatkmmyefetabherafetatemUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("MebtnatkmmyefetabherafetatemDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Mebtnatkmmyefetabherafetatem> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }
    List<Mebtnatkmmyefetabherafetatem> todayketero=null;
 public List<Mebtnatkmmyefetabherafetatem> getTodayketero(String today)
     { 
       System.out.println("Today ketero     =>"+today);
 if (todayketero == null) {
            todayketero = getFacade().getTodayketero(today);
        }
        return todayketero;

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

    public Mebtnatkmmyefetabherafetatem getMebtnatkmmyefetabherafetatem(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Mebtnatkmmyefetabherafetatem> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Mebtnatkmmyefetabherafetatem> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Mebtnatkmmyefetabherafetatem.class)
    public static class MebtnatkmmyefetabherafetatemControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            MebtnatkmmyefetabherafetatemController controller = (MebtnatkmmyefetabherafetatemController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "mebtnatkmmyefetabherafetatemController");
            return controller.getMebtnatkmmyefetabherafetatem(getKey(value));
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
            if (object instanceof Mebtnatkmmyefetabherafetatem) {
                Mebtnatkmmyefetabherafetatem o = (Mebtnatkmmyefetabherafetatem) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Mebtnatkmmyefetabherafetatem.class.getName()});
                return null;
            }
        }

    }
@PostConstruct
public void init() {
    selected = new Mebtnatkmmyefetabherafetatem();
}
}
