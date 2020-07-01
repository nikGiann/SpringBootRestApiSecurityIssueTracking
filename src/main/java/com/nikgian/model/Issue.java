package com.nikgian.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "issue")
public class Issue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotNull
    @Column(name = "title")
    private String title;
    @NotNull
    @Column(name = "descr")
    private String descr;
    @Column(name = "type")
    private String type;
    @Column(name = "createdateissue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdateissue;
    @Column(name = "editdateissue")
    @Temporal(TemporalType.TIMESTAMP)
    private Date editdateissue;
   @Column(name = "statusissue")
    private String statusissue;
    
    @JoinColumn(name = "assignedto", referencedColumnName = "uid")
    @ManyToOne
    private User assignedto;
    @JoinColumn(name = "lastuseredit", referencedColumnName = "uid")
    @ManyToOne
    private User lastuseredit;
    
    @JoinColumn(name = "usercreateissue", referencedColumnName = "uid")
    @ManyToOne
    private User usercreateissue;

    public Issue() {
    }

    public Issue(String title, String descr, String type, Date createdateissue, Date editdateissue, String statusissue, User assignedto, User lastuseredit, User usercreateissue) {
        this.title = title;
        this.descr = descr;
        this.type = type;
        this.createdateissue = createdateissue;
        this.editdateissue = editdateissue;
        this.statusissue = statusissue;
        this.assignedto = assignedto;
        this.lastuseredit = lastuseredit;
        this.usercreateissue = usercreateissue;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreatedateissue() {
        return createdateissue;
    }

    public void setCreatedateissue(Date createdateissue) {
        this.createdateissue = createdateissue;
    }

    public Date getEditdateissue() {
        return editdateissue;
    }

    public void setEditdateissue(Date editdateissue) {
        this.editdateissue = editdateissue;
    }

    public String getStatusissue() {
        return statusissue;
    }

    public void setStatusissue(String statusissue) {
        this.statusissue = statusissue;
    }

    public User getAssignedto() {
        return assignedto;
    }

    public void setAssignedto(User assignedto) {
        this.assignedto = assignedto;
    }

    public User getLastuseredit() {
        return lastuseredit;
    }

    public void setLastuseredit(User lastuseredit) {
        this.lastuseredit = lastuseredit;
    }

    public User getUsercreateissue() {
        return usercreateissue;
    }

    public void setUsercreateissue(User usercreateissue) {
        this.usercreateissue = usercreateissue;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.title);
        hash = 37 * hash + Objects.hashCode(this.descr);
        hash = 37 * hash + Objects.hashCode(this.type);
        hash = 37 * hash + Objects.hashCode(this.createdateissue);
        hash = 37 * hash + Objects.hashCode(this.editdateissue);
        hash = 37 * hash + Objects.hashCode(this.statusissue);
        hash = 37 * hash + Objects.hashCode(this.assignedto);
        hash = 37 * hash + Objects.hashCode(this.lastuseredit);
        hash = 37 * hash + Objects.hashCode(this.usercreateissue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Issue other = (Issue) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.descr, other.descr)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.statusissue, other.statusissue)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.createdateissue, other.createdateissue)) {
            return false;
        }
        if (!Objects.equals(this.editdateissue, other.editdateissue)) {
            return false;
        }
        if (!Objects.equals(this.assignedto, other.assignedto)) {
            return false;
        }
        if (!Objects.equals(this.lastuseredit, other.lastuseredit)) {
            return false;
        }
        if (!Objects.equals(this.usercreateissue, other.usercreateissue)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Issue{" + "id=" + id + ", title=" + title + ", descr=" + descr + ", type=" + type + ", createdateissue=" + createdateissue + ", editdateissue=" + editdateissue + ", statusissue=" + statusissue + ", assignedto=" + assignedto + ", lastuseredit=" + lastuseredit + ", usercreateissue=" + usercreateissue + '}';
    }

    
    
    
}
