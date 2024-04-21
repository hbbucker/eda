package br.com.bucker.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.runtime.annotations.RegisterForReflection;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@RegisterForReflection
@Entity(name = "balances")
public class BalancesModel extends PanacheEntityBase {
    @Id
    public String id;
    @Column(name = "account_id_from")
    public String accountIDFrom;
    @Column(name = "account_id_to")
    public String accountIDTo;
    @Column(name = "balance_account_id_from")
    public Double balanceAccountIDFrom;
    @Column(name = "balance_account_id_to")
    public Double balanceAccountIDTo;
    @Column(name = "timestamp")
    public LocalDateTime timestamp;
}
