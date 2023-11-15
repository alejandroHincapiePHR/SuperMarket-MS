package com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.adapter;

import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.entity.BillMySQLEntity;
import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.mappers.BillMapper;
import com.ms.supermarket.management.bill.adapters.out.dbs.mysql.springData.repository.BillMySQLRepository;
import com.ms.supermarket.management.bill.application.exceptions.BillNotFoundException;
import com.ms.supermarket.management.bill.application.ports.bill.out.BillCreatedPort;
import com.ms.supermarket.management.bill.application.ports.bill.out.GetBillByIDPort;
import com.ms.supermarket.management.bill.domain.finance.Bill;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BillMySQLAdapter implements BillCreatedPort, GetBillByIDPort {

    private BillMapper billMapper;
    private BillMySQLRepository billMySQLRepository;


    public BillMySQLAdapter(final BillMapper billMapper, final BillMySQLRepository billMySQLRepository) {
        this.billMapper = billMapper;
        this.billMySQLRepository = billMySQLRepository;
    }

    @Override
    public Long saveBill(Bill bill) {
        //TODO add logic to check id Bill is added
        BillMySQLEntity billMySQLEntity = billMySQLRepository.save(billMapper.toEntity(bill));
        return billMySQLEntity.getBillId();

    }

    @Override
    public Bill getBillById(Long id) throws BillNotFoundException {
        Optional<BillMySQLEntity> billMySQL = billMySQLRepository.findById(id);
        if (billMySQL.isPresent()) {
            return billMapper.toDomain(billMySQL.get());
        } else {
            throw new BillNotFoundException();
        }
    }
}
