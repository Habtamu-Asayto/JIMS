
package reports;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MonthsandDataFeedcovid implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    int positive;
    int negative;
    int death;
    int icuadmitted;
    int improved,disapeared,totalquarentied;
    String rowheading;
    String months;

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getRowheading() {
        return rowheading;
    }

    public void setRowheading(String rowheading) {
        this.rowheading = rowheading;
    }

    public int getPositive() {
        return positive;
    }

    public void setPositive(int positive) {
        this.positive = positive;
    }

    public int getNegative() {
        return negative;
    }

    public void setNegative(int negative) {
        this.negative = negative;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }

    public int getIcuadmitted() {
        return icuadmitted;
    }

    public void setIcuadmitted(int icuadmitted) {
        this.icuadmitted = icuadmitted;
    }

    public int getImproved() {
        return improved;
    }

    public void setImproved(int improved) {
        this.improved = improved;
    }

    public int getDisapeared() {
        return disapeared;
    }

    public void setDisapeared(int disapeared) {
        this.disapeared = disapeared;
    }

    public int getTotalquarentied() {
        return totalquarentied;
    }

    public void setTotalquarentied(int totalquarentied) {
        this.totalquarentied = totalquarentied;
    }

   
  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MonthsandDataFeedcovid)) {
            return false;
        }
        MonthsandDataFeedcovid other = (MonthsandDataFeedcovid) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mothers.db.MonthsandDataFeed[ id=" + id + " ]";
    }
    
}
