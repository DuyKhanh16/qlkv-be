package org.example.qlkv.exception;

import lombok.Getter;

@Getter
public enum Messeger {
     DELETE_OK("Xóa thành công"),
    DELETE_FAIL(" Không thể xóa"),
    SUCCESS("Thành công"),
    CONFLICT(" Đã tồn tại"),
    NOTFOUND("Không tồn tại")
    ;


   private String message;

   Messeger(String message) {
       this.message = message;
   }
}
