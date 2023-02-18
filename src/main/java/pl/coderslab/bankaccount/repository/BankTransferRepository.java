package pl.coderslab.bankaccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.bankaccount.entity.BankTransfer;

public interface BankTransferRepository extends JpaRepository<BankTransfer, Long> {
}
