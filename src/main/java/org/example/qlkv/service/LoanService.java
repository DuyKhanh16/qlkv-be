package org.example.qlkv.service;

import jakarta.persistence.Tuple;
import jakarta.transaction.Transactional;
import org.example.qlkv.DTO.request.LoanDto;
import org.example.qlkv.DTO.request.LoanExcelDto;
import org.example.qlkv.DTO.response.LoanResponse;
import org.example.qlkv.entity.Customer;
import org.example.qlkv.entity.Loan;
import org.example.qlkv.entity.LoanPurpose;
import org.example.qlkv.entity.Project;
import org.example.qlkv.exception.Messeger;
import org.example.qlkv.repository.CustomerRepo;
import org.example.qlkv.repository.LoanPurposeRepo;
import org.example.qlkv.repository.LoanRepo;
import org.example.qlkv.repository.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class LoanService {
    @Autowired
    private LoanRepo loanRepo;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private LoanPurposeRepo loanPurposeRepo;

    public List<LoanResponse> getListLoan(String role, String userLogin){
        List<Tuple> listTup = List.of();
        switch (role){
            case "ROLE_USER": listTup = loanRepo.getLoanByRoleUser(userLogin);

            case  "ROLE_MANAGE": listTup = loanRepo.getLoanByRoleManage(userLogin);

             case  "ROLE_ADMIN": listTup  =loanRepo.getLoanRelation();
        }

        if(!listTup.isEmpty()){
            return  listTup.stream().map(row->new LoanResponse(
                            row.get("loanId", Integer.class),
                            row.get("contractNo", String.class),
                            row.get("borrOwer", String.class),
                            row.get("lender", String.class),
                            row.get("usedCap", String.class),
                            row.get("contractType", String.class),
                            row.get("projectName", String.class),
                            row.get("loanName", String.class),
                            row.get("loanAmount", BigDecimal.class),
                            row.get("ccy", String.class),
                            row.get("interestRate1", BigDecimal.class),
                            row.get("descriptionInterestRate", String.class),
                            row.get("fee1", BigDecimal.class),
                            row.get("fee2", BigDecimal.class),
                            row.get("fee3", BigDecimal.class),
                            row.get("loanPeriod", String.class),
                            row.get("fromDate", LocalDateTime.class),
                            row.get("endDate", LocalDateTime.class),
                            row.get("equityCapital", BigDecimal.class),
                            row.get("comment", String.class),
                            row.get("mangUser", String.class),
                            row.get("loanStatus", String.class)
                    ))
                    .collect(Collectors.toList());
        }

        return Collections.emptyList(); // Return empty list if result is empty

    }

    public Loan getOneLoan(int id){
        return loanRepo.findByLoanId(id);
    }

    public Loan createNewLoan (LoanDto loan){
        Optional<Loan> loanOptional = loanRepo.findByContractNo(loan.getContractNo());
        if(loanOptional.isPresent()){
            throw new RuntimeException(Messeger.CONFLICT.getMessage());
        }
        BigDecimal tatal= loan.getLoanAmountPurpose1()
                .add(loan.getLoanAmountPurpose2())
                .add(loan.getLoanAmountPurpose3())
                .add(loan.getLoanAmountPurpose4())
                .add(loan.getLoanAmountPurpose5())
                .add(loan.getLoanAmountPurpose6())
                .add(loan.getLoanAmountPurpose7());
        if ((loan.getLoanAmount()).compareTo(tatal) < 0) throw  new RuntimeException("Tổng số tiền Hạn mức giải ngân mục đích vay phải nhỏ hơn hoặc bằng Hạn mức giải ngân");
      Loan loanSave = convertLoan(loan);
        return loanRepo.save(loanSave);
    };


    private  Loan convertLoan(LoanDto loanDto){
        Loan loan = new Loan();
        loan.setInputedDate(LocalDateTime.now());
        loan.setDayBasis("366/365");
        loan.setContractNo(loanDto.getContractNo());
        loan.setContractType(loanDto.getContractType());
        loan.setBorrowerId(loanDto.getBorrowerId());
        loan.setLenderId(loanDto.getLenderId());
        loan.setUsedCapId(loanDto.getUsedCapId());
        loan.setProjectId1(loanDto.getProjectId1());
        loan.setLoanName(loanDto.getLoanName());
        loan.setPurposeId1(loanDto.getPurposeId1());
        loan.setPurposeId2(loanDto.getPurposeId2()==null?0:loanDto.getPurposeId2());
        loan.setPurposeId3(loanDto.getPurposeId3()==null?0:loanDto.getPurposeId3());
        loan.setPurposeId4(loanDto.getPurposeId4()==null?0:loanDto.getPurposeId4());
        loan.setPurposeId5(loanDto.getPurposeId5()==null?0:loanDto.getPurposeId5());
        loan.setPurposeId6(loanDto.getPurposeId6()==null?0:loanDto.getPurposeId6());
        loan.setPurposeId7(loanDto.getPurposeId7()==null?0:loanDto.getPurposeId7());
        loan.setLoanAmountPurpose1(loanDto.getLoanAmountPurpose1());
        loan.setLoanAmountPurpose2(loanDto.getLoanAmountPurpose2());
        loan.setLoanAmountPurpose3(loanDto.getLoanAmountPurpose3());
        loan.setLoanAmountPurpose4(loanDto.getLoanAmountPurpose4());
        loan.setLoanAmountPurpose5(loanDto.getLoanAmountPurpose5());
        loan.setLoanAmountPurpose6(loanDto.getLoanAmountPurpose6());
        loan.setLoanAmountPurpose7(loanDto.getLoanAmountPurpose7());
        loan.setFromDate(convertTime(loanDto.getFromDate().toString()));
        loan.setEndDate(convertTime(loanDto.getEndDate().toString()));
        loan.setLoanAmount(loanDto.getLoanAmount());
        loan.setCcy(loanDto.getCcy());
        loan.setLoanStatus(loanDto.getLoanStatus());
        loan.setComment(loanDto.getComment());
        loan.setMangUser(loanDto.getMangUser());
        loan.setInputedUser(loanDto.getInputedUser());
        loan.setLoanPeriod(loanDto.getLoanPeriod());
        loan.setEquityCapital(loanDto.getEquityCapital());
        loan.setInterestRate1(loanDto.getInterestRate1());
        loan.setDescriptionInterestRate(loanDto.getDescriptionInterestRate());
        loan.setFee1(loanDto.getFee1());
        loan.setFee2(loanDto.getFee2());
        loan.setFee3(loanDto.getFee3());
        loan.setDescription(loanDto.getDescription());
        return loan;
    }
    private LocalDateTime convertTime(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Date date1 = new  Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date1.toInstant(), ZoneId.systemDefault())
                .withHour(0)
                .withMinute(0)
                .withSecond(0)
                .withNano(0);

        return localDateTime;
    }

    @Transactional
    public List<String> deleteListLoan (List<Integer> list){
        List<String> listErr =new ArrayList<>();
        for (Integer i : list){
            Optional<Loan> checkDrawdown =loanRepo.findRelationDrawdown(i);
            if (checkDrawdown.isPresent())listErr.add(checkDrawdown.get().getContractNo());
            else loanRepo.deleteByLoanId(i);
        }
      return listErr;
    }

    public List<Loan> saveLoanExcel (List<LoanExcelDto> listLoan, String inputedUser){
        List<Loan> loans = listLoan.stream()
                .map(this::convertListLoanExcel)
                .filter(this::checkContractNo)
                .map(loan -> processCustomer(loan,inputedUser))
                .collect(Collectors.toList());

        return loanRepo.saveAll(loans);
    }

    private Loan convertListLoanExcel (LoanExcelDto loanDTO){
        System.out.println(loanDTO);
       Loan loan = new Loan();
        loan.setBorrowerId(convertIDCustommer(loanDTO.getBorrowerID()));
        loan.setContractNo(loanDTO.getContractNo());
        loan.setContractType(loanDTO.getContractType());
        loan.setDescription(loanDTO.getDescription());
        loan.setDescriptionInterestRate(loanDTO.getDescriptionInterestRate());
        loan.setEndDate(convertTime(loanDTO.getEndDate()));
        loan.setEquityCapital(loanDTO.getEquityCapital());
        loan.setFee1(loanDTO.getFee1());
        loan.setFee2(loanDTO.getFee2());
        loan.setFee3(loanDTO.getFee3());
        loan.setFromDate(convertTime(loanDTO.getFromDate()));
        loan.setInterestRate1(loanDTO.getInterestRate1());
        loan.setLenderId(convertIDCustommer(loanDTO.getLenderID()));
        loan.setLoanAmount(loanDTO.getLoanAmount());
        loan.setLoanAmountPurpose1(loanDTO.getLoanAmountPurpose1());
        loan.setLoanAmountPurpose2(loanDTO.getLoanAmountPurpose2());
        loan.setLoanAmountPurpose3(loanDTO.getLoanAmountPurpose3());
        loan.setLoanAmountPurpose4(loanDTO.getLoanAmountPurpose4());
        loan.setLoanAmountPurpose5(loanDTO.getLoanAmountPurpose5());
        loan.setLoanAmountPurpose6(loanDTO.getLoanAmountPurpose6());
        loan.setLoanAmountPurpose7(loanDTO.getLoanAmountPurpose7());
        loan.setLoanName(loanDTO.getLoanName());
        loan.setLoanStatus(loanDTO.getLoanStatus());
        loan.setMangUser(loanDTO.getMangUser());
        loan.setProjectId1(convertIdProject(loanDTO.getProjectID1()));
        loan.setPurposeId1(convertPurpose(loanDTO.getPurposeID1()));
        loan.setPurposeId2(convertPurpose(loanDTO.getPurposeID2()));
        loan.setPurposeId3(convertPurpose(loanDTO.getPurposeID3()));
        loan.setPurposeId4(convertPurpose(loanDTO.getPurposeID4()));
        loan.setPurposeId5(convertPurpose(loanDTO.getPurposeID5()));
        loan.setPurposeId6(convertPurpose(loanDTO.getPurposeID6()));
        loan.setPurposeId7(convertPurpose(loanDTO.getPurposeID7()));
        loan.setUsedCapId(convertIDCustommer(loanDTO.getUsedCapID()));
        return loan;
    }

    private boolean checkContractNo (Loan loan){
        Optional<Loan> loanOptional = loanRepo.findByContractNo(loan.getContractNo());
        if(loanOptional.isPresent()){
            throw new RuntimeException(loan.getContractNo() + " " +Messeger.CONFLICT.getMessage());
        }
        return loanOptional.isEmpty();
    }

    private Integer convertIDCustommer(String name){
        Customer customer = customerRepo.findByName(name);
        if(customer!=null){
            return customer.getId();
        }else  throw new RuntimeException(name + " " + Messeger.NOTFOUND.getMessage());
    }

    private Integer convertIdProject(String nameProject ){
        Project project =projectRepo.findByProjectName(nameProject);
        if(project!=null){
          return project.getId();
        }else  throw new RuntimeException(nameProject + " " + Messeger.NOTFOUND.getMessage());
    }

    private Integer convertPurpose(String purpose){
        if(purpose==null)return null;
        LoanPurpose loanPurpose =loanPurposeRepo.findByPurposeName(purpose);
        if(loanPurpose!=null){
            return loanPurpose.getId();
        }else  throw new RuntimeException(purpose + " " + Messeger.NOTFOUND.getMessage());
    }

    private Loan processCustomer(Loan loan,String inputedUser){
        loan.setInputedUser(inputedUser);
        loan.setInputedDate(LocalDateTime.now());
        return loan;
    }
}
