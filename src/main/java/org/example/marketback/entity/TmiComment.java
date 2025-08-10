package org.example.marketback.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TmiComment extends AuditingFields {

    @Column(length = 100)
    private String content;

    @ManyToOne
    @JoinColumn(name = "tmi_id")
    private Tmi tmi;
}
