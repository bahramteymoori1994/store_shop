/*==============================================================*/
/* DBMS name:      ORACLE Version 19c                           */
/* Created on:     8/9/2024 5:14:08 PM                          */
/*==============================================================*/
create sequence CHEQUE_SEQ
start with 1
 maxvalue 9999999999
 nominvalue
nocycle
 cache 100
noorder
nokeep
global
/

create sequence CUSTOMER_SEQ
start with 1
 maxvalue 9999999999
 nominvalue
nocycle
 cache 100
noorder
nokeep
global
/

create sequence EMPLOYEE_STORE_SEQ
start with 1
 maxvalue 9999999999
 nominvalue
nocycle
 cache 100
noorder
nokeep
global
/

create sequence MANAGER_SEQ
start with 1
 maxvalue 9999999999
 nominvalue
nocycle
 cache 100
noorder
nokeep
global
/

create sequence PRODUCT_SEQ
start with 1
 maxvalue 9999999999
 nominvalue
nocycle
 cache 100
noorder
nokeep
global
/

create sequence STORAGE_SEQ
start with 1
 maxvalue 9999999999
 nominvalue
nocycle
 cache 100
noorder
nokeep
global
/

/*==============================================================*/
/* Table: CHEQUE                                                */
/*==============================================================*/
create table CHEQUE (
   "cheque_id"          NUMBER(10)            not null,
   "person_id"          NUMBER(10),
   "manager_id"         NUMBER(10),
   "cheque_product_count" NUMBER(10)            not null,
   "cheque_register_date" DATE                  not null,
   constraint PK_CHEQUE primary key ("cheque_id")
)
/

/*==============================================================*/
/* Index: FK_CHEQUE_S03                                         */
/*==============================================================*/
create index FK_CHEQUE_S03 on CHEQUE (
   "person_id" ASC
)
/

/*==============================================================*/
/* Index: FK_CHEQUE_S04                                         */
/*==============================================================*/
create index FK_CHEQUE_S04 on CHEQUE (
   "manager_id" ASC
)
/

/*==============================================================*/
/* Table: CUSTOMER                                              */
/*==============================================================*/
create table CUSTOMER (
   "customer_id"        NUMBER(10)            not null,
   "customer_name"      NVARCHAR2(50)         not null,
   "customer_family"    NVARCHAR2(50)         not null,
   "customer_national_code" VARCHAR2(10)          not null,
   "customer_cell_phone" VARCHAR2(11)          not null,
   "customer_email"     VARCHAR2(100)         not null,
   constraint PK_CUSTOMER primary key ("customer_id"),
   constraint AK_UK_CUSTOMER_CUSTOMER unique ("customer_national_code", "customer_cell_phone", "customer_email")
)
/

/*==============================================================*/
/* Table: EMPLOYEE                                              */
/*==============================================================*/
create table EMPLOYEE (
   "employee_id"        NUMBER(10)            not null,
   "manager_id"         NUMBER(10),
   "employee_name"      NVARCHAR2(50)         not null,
   "employee_family"    NVARCHAR2(50)         not null,
   "employee_cell_phone" VARCHAR2(11)          not null,
   constraint PK_EMPLOYEE primary key ("employee_id"),
   constraint AK_UK_EMPLOYEE_EMPLOYEE unique ("employee_cell_phone")
)
/

/*==============================================================*/
/* Index: FK_EMPLOYEE_S07                                       */
/*==============================================================*/
create index FK_EMPLOYEE_S07 on EMPLOYEE (
   "manager_id" ASC
)
/

/*==============================================================*/
/* Table: MANAGER                                               */
/*==============================================================*/
create table MANAGER (
   "manager_id"         NUMBER(10)            not null,
   "manager_name"       NVARCHAR2(50)         not null,
   "manager_family"     NVARCHAR2(50)         not null,
   "manager_national_code" NVARCHAR2(10)         not null,
   "manager_cell_phone" VARCHAR2(11),
   constraint PK_MANAGER primary key ("manager_id"),
   constraint AK_UK_MANAGER_MANAGER unique ("manager_national_code", "manager_cell_phone")
)
/

/*==============================================================*/
/* Table: PRODUCT                                               */
/*==============================================================*/
create table PRODUCT (
   "product_id"         NUMBER(10)            not null,
   "person_id"          NUMBER(10)            not null,
   "storage_id"         NUMBER(10)            not null,
   "product_number"     VARCHAR2(20)          not null,
   "product_name"       NVARCHAR2(50)         not null,
   "product_model"      NVARCHAR2(20)         not null,
   "product_buy_price"  NUMBER(10,2)          not null,
   "product_count"      NUMBER(10)            not null,
   constraint PK_PRODUCT primary key ("product_id"),
   constraint AK_UK_PRODUCT_PRODUCT unique ("product_number")
)
/

/*==============================================================*/
/* Index: FK_PRODUCT_S05                                        */
/*==============================================================*/
create index FK_PRODUCT_S05 on PRODUCT (
   "person_id" ASC
)
/

/*==============================================================*/
/* Index: FK_PRODUCT_S06                                        */
/*==============================================================*/
create index FK_PRODUCT_S06 on PRODUCT (
   "storage_id" ASC
)
/

/*==============================================================*/
/* Table: PRODUCT_CHEQUE                                        */
/*==============================================================*/
create table PRODUCT_CHEQUE (
   "cheque_id"          NUMBER(10)            not null,
   "product_id"         NUMBER(10)            not null,
   constraint PK_PRODUCT_CHEQUE primary key ("cheque_id", "product_id")
)
/

/*==============================================================*/
/* Index: FK_PRODUCT__S08                                       */
/*==============================================================*/
create index FK_PRODUCT__S08 on PRODUCT_CHEQUE (
   "product_id" ASC
)
/

/*==============================================================*/
/* Index: FK_PRODUCT__S09                                       */
/*==============================================================*/
create index FK_PRODUCT__S09 on PRODUCT_CHEQUE (
   "cheque_id" ASC
)
/

/*==============================================================*/
/* Table: STORAGE                                               */
/*==============================================================*/
create table STORAGE (
   "storage_id"         NUMBER(10)            not null,
   "manager_id"         NUMBER(10),
   "employee_id"        NUMBER(10),
   constraint PK_STORAGE primary key ("storage_id")
)
/

/*==============================================================*/
/* Index: FK_STORAGE_S02                                        */
/*==============================================================*/
create index FK_STORAGE_S02 on STORAGE (
   "manager_id" ASC
)
/

/*==============================================================*/
/* Index: FK_STORAGE_S01                                        */
/*==============================================================*/
create index FK_STORAGE_S01 on STORAGE (
   "employee_id" ASC
)
/

alter table CHEQUE
   add constraint FK_CHEQUE_S03_CUSTOMER foreign key ("person_id")
      references CUSTOMER ("customer_id")
/

alter table CHEQUE
   add constraint FK_CHEQUE_S04_MANAGER foreign key ("manager_id")
      references MANAGER ("manager_id")
/

alter table EMPLOYEE
   add constraint FK_EMPLOYEE_S07_MANAGER foreign key ("manager_id")
      references MANAGER ("manager_id")
/

alter table PRODUCT
   add constraint FK_PRODUCT_S05_CUSTOMER foreign key ("person_id")
      references CUSTOMER ("customer_id")
/

alter table PRODUCT
   add constraint FK_PRODUCT_S06_STORAGE foreign key ("storage_id")
      references STORAGE ("storage_id")
/

alter table PRODUCT_CHEQUE
   add constraint FK_PRODUCT__S08_PRODUCT foreign key ("product_id")
      references PRODUCT ("product_id")
/

alter table PRODUCT_CHEQUE
   add constraint FK_PRODUCT__S09_CHEQUE foreign key ("cheque_id")
      references CHEQUE ("cheque_id")
/

alter table STORAGE
   add constraint FK_STORAGE_S01_EMPLOYEE foreign key ("employee_id")
      references EMPLOYEE ("employee_id")
/

alter table STORAGE
   add constraint FK_STORAGE_S02_MANAGER foreign key ("manager_id")
      references MANAGER ("manager_id")
/