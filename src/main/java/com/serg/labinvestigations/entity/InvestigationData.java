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
    private String details1;
    @Column(nullable = true)
    private String details2;
    @Column(nullable = true)
    private String details3;
    @Column(nullable = true)
    private String details4;
    @Column(nullable = true)
    private String details5;
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
    @Column(nullable = true)
    private String field47;
    @Column(nullable = true)
    private String field48;
    @Column(nullable = true)
    private String field49;
    @Column(nullable = true)
    private String field50;
    @Column(nullable = true)
    private String field51;
    @Column(nullable = true)
    private String field52;
    @Column(nullable = true)
    private String field53;
    @Column(nullable = true)
    private String field54;
    @Column(nullable = true)
    private String field55;
    @Column(nullable = true)
    private String field56;
    @Column(nullable = true)
    private String field57;
    @Column(nullable = true)
    private String field58;
    @Column(nullable = true)
    private String field59;
    @Column(nullable = true)
    private String field60;
    @Column(nullable = true)
    private String field61;
    @Column(nullable = true)
    private String field62;
    @Column(nullable = true)
    private String field63;
    @Column(nullable = true)
    private String field64;
    @Column(nullable = true)
    private String field65;
    @Column(nullable = true)
    private String field66;
    @Column(nullable = true)
    private String field67;
    @Column(nullable = true)
    private String field68;
    @Column(nullable = true)
    private String field69;
    @Column(nullable = true)
    private String field70;
    @Column(nullable = true)
    private String field71;
    @Column(nullable = true)
    private String field72;
    @Column(nullable = true)
    private String field73;
    @Column(nullable = true)
    private String field74;
    @Column(nullable = true)
    private String field75;
    @Column(nullable = true)
    private String field76;
    @Column(nullable = true)
    private String field77;
    @Column(nullable = true)
    private String field78;
    @Column(nullable = true)
    private String field79;
    @Column(nullable = true)
    private String field80;
    @Column(nullable = true)
    private String field81;
    @Column(nullable = true)
    private String field82;
    @Column(nullable = true)
    private String field83;
    @Column(nullable = true)
    private String field84;
    @Column(nullable = true)
    private String field85;
    @Column(nullable = true)
    private String field86;
    @Column(nullable = true)
    private String field87;
    @Column(nullable = true)
    private String field88;
    @Column(nullable = true)
    private String field89;
    @Column(nullable = true)
    private String field90;
    @Column(nullable = true)
    private String field91;
    @Column(nullable = true)
    private String field92;
    @Column(nullable = true)
    private String field93;
    @Column(nullable = true)
    private String field94;
    @Column(nullable = true)
    private String field95;
    @Column(nullable = true)
    private String field96;
    @Column(nullable = true)
    private String field97;
    @Column(nullable = true)
    private String field98;
    @Column(nullable = true)
    private String field99;
    @Column(nullable = true)
    private String field100;
    @Column(nullable = true)
    private String field101;
    @Column(nullable = true)
    private String field102;
    @Column(nullable = true)
    private String field103;
    @Column(nullable = true)
    private String field104;
    @Column(nullable = true)
    private String field105;
    @Column(nullable = true)
    private String field106;
    @Column(nullable = true)
    private String field107;
    @Column(nullable = true)
    private String field108;
    @Column(nullable = true)
    private String field109;
    @Column(nullable = true)
    private String field110;

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
