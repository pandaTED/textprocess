package cn.panda.textprocess.entity;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * Created by lingj on 2017/2/16 0016.
 */
@Data
@Entity
@Table
public class Words {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
   private String word;    //分词
   private Integer times;  //出现的次数

}
