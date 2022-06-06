/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

 
@ManagedBean(name="themeService", eager = true)
@ApplicationScoped
public class ThemeService {
 
    private List<Theme> themes;
 
    @PostConstruct
    public void init() {
        themes = new ArrayList<Theme>();
        themes.add(new Theme(0, "start", "start"));
        themes.add(new Theme(1, "bootstrap", "bootstrap"));
        themes.add(new Theme(2, "Afterwork", "afterwork"));
        themes.add(new Theme(3, "Aristo", "aristo"));
        
    }
 
    public List<Theme> getThemes() {
        return themes;
    }
}