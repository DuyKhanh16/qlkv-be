package org.example.qlkv.DTO.response;

import lombok.Data;

@Data
public class ProjectSelectDTO {
   private int id;
   private String projectName;
   private String projectNo;

   public ProjectSelectDTO(int id, String projectName, String projectNo) {
       this.id = id;
       this.projectName = projectName;
       this.projectNo = projectNo;
   }
}
