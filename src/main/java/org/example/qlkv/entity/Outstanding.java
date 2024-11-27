package org.example.qlkv.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "Outstanding")
public class Outstanding {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "LoanID", nullable = false)
    private int loanId;

    @Column(name = "DrawdownID", nullable = false)
    private int drawdownId;

    @Column(name = "Event_date", nullable = false)
    private Date eventDate;

    @Column(name = "IntRate", nullable = false)
    private BigDecimal intRate;

    @Column(name = "PRI_OUTSTANDING", nullable = false)
    private BigDecimal priOutstanding;

    @Column(name = "Created_Date", nullable = false)
    private Date createdDate;

}
