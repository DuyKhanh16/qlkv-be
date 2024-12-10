package org.example.qlkv.service;

import org.example.qlkv.DTO.request.CreateCustomDto;
import org.example.qlkv.DTO.request.CustomerExcelDTO;
import org.example.qlkv.entity.Customer;
import org.example.qlkv.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepo customerRepository;


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
    LocalDateTime mow = LocalDateTime.now();

    public List<Customer> getAllKhachHang() {
        List<Customer> listKH = customerRepository.findAll();
        return listKH;
    }

    public Customer checkAbbreviation (String abbreviation) {
        return customerRepository.findByAbbreviation(abbreviation);
    }
    public Customer checkName (String name) {
        return customerRepository.findByName(name);
    }

//    Tạo 1 customer từ dot
    public Object createCustomer(CreateCustomDto customer) {

        Customer newCustomer = new Customer();
        newCustomer.setName(customer.getName());
        newCustomer.setAbbreviation(customer.getAbbreviation());
        newCustomer.setAddress(customer.getAddress());
        newCustomer.setPhone(customer.getPhone());
        newCustomer.setEmail(customer.getEmail());
        newCustomer.setBusRegist(customer.getBusRegist());
        newCustomer.setMangUser(customer.getMangUser());
        newCustomer.setInputedDate(mow);
        newCustomer.setInputedUser(customer.getInputedUser());
        newCustomer.setCharterCapital(customer.getCharterCapital());
        newCustomer.setRecentProfit(customer.getRecentProfit());
        newCustomer.setRecentRevenue(customer.getRecentRevenue());
        newCustomer.setCusAccountNumber(customer.getCusAccountNumber());
        newCustomer.setCustomerType(customer.getCustomerType());
        newCustomer.setGender(customer.getGender());
        newCustomer.setDateOfBirth(LocalDate.parse(customer.getDateOfBirth(), formatter));
        newCustomer.setDateOfIssue(LocalDate.parse(customer.getDateOfIssue(),formatter));
        newCustomer.setPlaceOfIssue(customer.getPlaceOfIssue());
        newCustomer.setBankName(customer.getBankName());
        return customerRepository.save(newCustomer);
    }

//    Xử lý excel
    public   List<Customer> saveCustomers(List<CustomerExcelDTO> customerExcelDTO ,String mangUser,String inputedUser) {
        List<Customer> customers = customerExcelDTO.stream()
                .map(this::convertToEntity)
                .filter(this::isValidCustomer)
                .map(customer -> processCustomer(customer, mangUser, inputedUser))
                .collect(Collectors.toList());

        return customerRepository.saveAll(customers);
    }
    private Customer processCustomer(Customer customer, String mangUser, String inputedUser) {
        // Thêm thông tin hệ thống
        customer.setMangUser(mangUser);
        customer.setInputedDate(LocalDateTime.now());
        customer.setInputedUser(inputedUser);

        return customer;
    }
    private boolean isValidCustomer(Customer customer) {
        Optional<Customer> existingCustomer = customerRepository.findByAbbreviationAndName(
                customer.getAbbreviation(),
                customer.getName()
        );
        if (existingCustomer.isPresent()) {
            throw new RuntimeException("Tên khách hàng hoặc tên viết tắt đã tồn tại trong hệ thống");
        }
        return existingCustomer.isEmpty(); // Chỉ lưu nếu không trùng
    }
    public Customer convertToEntity(CustomerExcelDTO dto) {
        Customer customer = new Customer();
        customer.setName(dto.getName());
        customer.setAbbreviation(dto.getAbbreviation());
        customer.setAddress(dto.getAddress());
        customer.setBusRegist(dto.getBusRegist());
        customer.setCharterCapital(dto.getCharterCapital());
        customer.setRecentRevenue(dto.getRecentRevenue());
        customer.setRecentProfit(dto.getRecentProfit());
        customer.setCusAccountNumber(dto.getCusAccountNumber());
        customer.setCustomerType(convertCustomerType(dto.getCustomerType())); // Chuyển đổi customerType
        customer.setGender(convertGender(dto.getGender())); // Chuyển đổi gender
        customer.setDateOfBirth(convertDate(dto.getDateOfBirth()));
        customer.setDateOfIssue(convertDate(dto.getDateOfIssue()));
        customer.setPlaceOfIssue(dto.getPlaceOfIssue());
        customer.setPhone(dto.getPhone());
        customer.setEmail(dto.getEmail());
        customer.setBankName(dto.getBankName());
        return customer;
    }

    private Integer convertCustomerType(String customerType) {
        if ("Tổ chức".equalsIgnoreCase(customerType)) {
            return 1;
        } else if ("Cá nhân".equalsIgnoreCase(customerType)) {
            return 2;
        }
        return null; // Giá trị mặc định nếu không hợp lệ
    }

    private Integer convertGender(String gender) {
        if ("Nam".equalsIgnoreCase(gender)) {
            return 1;
        } else if ("Nữ".equalsIgnoreCase(gender)) {
            return 2;
        }
        return null;
    }

    private LocalDate convertDate(String date) {
        if (date == null || date.isEmpty()) {
            return null;
        }
        LocalDate result = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
        return   result = LocalDate.parse(date, formatter);
        }catch (Exception e) {
            throw new RuntimeException("Định dạng ngày không đúng");
        }
    }

//    xóa customer
    public List<String> deleteCustomer(List<Integer> listID) {
        List<String> customerList = new ArrayList<>();
        for (Integer id : listID) {
            Customer customer=customerRepository.findRelationshipProject(id);
            if (customer != null) {
                customerList.add(customer.getName());
            }else {
                customerRepository.deleteById(id);
            }

        }
        return customerList;
    }
//    Update customer
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
