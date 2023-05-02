package com.serg.labinvestigations.entity;

import com.serg.labinvestigations.types.InvestigationType;
import jakarta.persistence.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InvestigationData implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private InvestigationType investigationType;
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private String origin;
    @Column(nullable = false)
    private LocalDate date;
    @Column(nullable = true)
    private String details;
    @Column(nullable = true)
    private String age;
    @Column(nullable = true)
    private String patientType;
    @Column(nullable = true)
    private String gender;
    @Column(nullable = true)
    private String field1;
    @Column(nullable = true)
    private String field2;
    @Column(nullable = true)
    private String field3;
    @Column(nullable = true)
    private String field4;
    @Column(nullable = true)
    private String field5;
    @Column(nullable = true)
    private String field6;
    @Column(nullable = true)
    private String field7;
    @Column(nullable = true)
    private String field8;
    @Column(nullable = true)
    private String field9;
    @Column(nullable = true)
    private String field10;
    @Column(nullable = true)
    private String field11;
    @Column(nullable = true)
    private String field12;
    @Column(nullable = true)
    private String field13;
    @Column(nullable = true)
    private String field14;
    @Column(nullable = true)
    private String field15;
    @Column(nullable = true)
    private String field16;
    @Column(nullable = true)
    private String field17;
    @Column(nullable = true)
    private String field18;
    @Column(nullable = true)
    private String field19;
    @Column(nullable = true)
    private String field20;
    @Column(nullable = true)
    private String field21;
    @Column(nullable = true)
    private String field22;
    @Column(nullable = true)
    private String field23;
    @Column(nullable = true)
    private String field24;
    @Column(nullable = true)
    private String field25;
    @Column(nullable = true)
    private String field26;
    @Column(nullable = true)
    private String field27;
    @Column(nullable = true)
    private String field28;
    @Column(nullable = true)
    private String field29;
    @Column(nullable = true)
    private String field30;
    @Column(nullable = true)
    private String field31;
    @Column(nullable = true)
    private String field32;
    @Column(nullable = true)
    private String field33;
    @Column(nullable = true)
    private String field34;
    @Column(nullable = true)
    private String field35;
    @Column(nullable = true)
    private String field36;
    @Column(nullable = true)
    private String field37;
    @Column(nullable = true)
    private String field38;
    @Column(nullable = true)
    private String field39;
    @Column(nullable = true)
    private String field40;
    @Column(nullable = true)
    private String field41;
    @Column(nullable = true)
    private String field42;
    @Column(nullable = true)
    private String field43;
    @Column(nullable = true)
    private String field44;
    @Column(nullable = true)
    private String field45;
    @Column(nullable = true)
    private String field46;

    @Transient
    private ImageView deleteImageView = new ImageView(new Image("delete.png"));

    public String getInvestigationTypeValue() {
        return investigationType.getValue();
    }

    public ImageView getDeleteImage() {
        return deleteImageView;
    }

    public String getDateFormatted() {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
