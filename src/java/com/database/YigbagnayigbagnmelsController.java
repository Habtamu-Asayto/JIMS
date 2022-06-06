package com.database;

import com.databse.util.JsfUtil;
import com.databse.util.JsfUtil.PersistAction;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
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

@Named("yigbagnayigbagnmelsController")
@SessionScoped
public class YigbagnayigbagnmelsController implements Serializable {

    @EJB
    private com.database.YigbagnayigbagnmelsFacade ejbFacade;
    private List<Yigbagnayigbagnmels> items = null;
    private Yigbagnayigbagnmels selected;

    public YigbagnayigbagnmelsController() {
    }

    public Yigbagnayigbagnmels getSelected() {
        return selected;
    }

    public void setSelected(Yigbagnayigbagnmels selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private YigbagnayigbagnmelsFacade getFacade() {
        return ejbFacade;
    }

    public Yigbagnayigbagnmels prepareCreate() {
        selected = new Yigbagnayigbagnmels();
        initializeEmbeddableKey();
        return selected;
    }

    public void create() {
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("YigbagnayigbagnmelsCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("YigbagnayigbagnmelsUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("YigbagnayigbagnmelsDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<Yigbagnayigbagnmels> getItems() {
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

    public Yigbagnayigbagnmels getYigbagnayigbagnmels(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<Yigbagnayigbagnmels> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<Yigbagnayigbagnmels> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = Yigbagnayigbagnmels.class)
    public static class YigbagnayigbagnmelsControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            YigbagnayigbagnmelsController controller = (YigbagnayigbagnmelsController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "yigbagnayigbagnmelsController");
            return controller.getYigbagnayigbagnmels(getKey(value));
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
            if (object instanceof Yigbagnayigbagnmels) {
                Yigbagnayigbagnmels o = (Yigbagnayigbagnmels) object;
                return getStringKey(o.getId());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), Yigbagnayigbagnmels.class.getName()});
                return null;
            }
        }

    }

}
