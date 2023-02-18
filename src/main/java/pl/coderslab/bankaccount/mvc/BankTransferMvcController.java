package pl.coderslab.bankaccount.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.coderslab.bankaccount.dao.BankTransferDao;
import pl.coderslab.bankaccount.entity.BankTransfer;



@Controller
@RequestMapping("/mvc/transfers")

public class BankTransferMvcController {
    private final BankTransferDao bankTransferDao;
    public BankTransferMvcController(BankTransferDao bankTransferDao) {
        this.bankTransferDao = bankTransferDao;
    }


    @GetMapping("/create")
    public String prepareCreateView() {
        return "/create-transfer";
    }


    @PostMapping("/create")
    public String processCreateRequest(@RequestParam String address, @RequestParam String account, @RequestParam String title, @RequestParam String sum, Model model) {
        BankTransfer bankTransfer = new BankTransfer();
        bankTransfer.setAddress(address);
        bankTransfer.setAccount(account);
        bankTransfer.setTitle(title);
        bankTransfer.setSum(sum);

        return "create-transfer-success";
    }


}
