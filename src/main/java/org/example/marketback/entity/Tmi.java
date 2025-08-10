package org.example.marketback.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tmi extends AuditingFields {
    
    private String content;
    
    @ManyToOne
    @JoinColumn(name = "market_id")
    private Market market;
}
