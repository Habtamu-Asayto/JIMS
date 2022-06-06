/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Bean {
    private List<String> values;

    @PostConstruct
    public void init() {
        values = new ArrayList();
        values.add("fgfdg");
        values.add("ssd");
        values.add("ds");
        values.add("dd");
    }

    public void submit() {
        // save values in database
    }

    public void extend() {
        values.add("");
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public List<String> getValues() {
        return values;
    }
}