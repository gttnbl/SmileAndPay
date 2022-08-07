 create table ADDRESS (ID integer not null, NUMBER integer, STREET varchar(255), ZIP_CODE varchar(255), MARCHANT_ID integer, primary key (ID)) ;
 create table MARCHANT (ID integer not null, BIRTHDATE timestamp, CREATION_DATE timestamp, LASTNAME varchar(255), NAME varchar(255), primary key (ID));
 create table MARCHANT_ADDRESS (MARCHANT_ID integer not null, address_ID integer not null);
 create table PRODUCT (ID integer not null, CREATE_DATE timestamp, CURRENCY varchar(255), HEIGHT int8, LABEL varchar(255), UNIT_PRICE int8, WEIGHT int8, primary key (ID));
 create table marchant_product (marchant_product_ID  bigserial not null, REGISTERED_DATE timestamp, MARCHANT_ID integer, PRODUCT_ID integer, primary key (marchant_product_ID));
 
 
 alter table MARCHANT_ADDRESS add constraint UK_MARCHANT_ADDRESS  unique (address_ID);
 alter table ADDRESS add constraint FK_pp08xp40nt16mqd6a5d804jt4 foreign key (MARCHANT_ID) references MARCHANT;
 alter table MARCHANT_ADDRESS add constraint FK_ADDRESS_MARCHANT foreign key (address_ID) references ADDRESS;
 alter table MARCHANT_ADDRESS add constraint FK_MARCHANT_ADDRESS foreign key (MARCHANT_ID) references MARCHANT;
 alter table marchant_product add constraint FK_MARCHANT_PRODUCT foreign key (MARCHANT_ID) references MARCHANT;
 alter table marchant_product add constraint FK_PRODUCT_MARCHANT foreign key (PRODUCT_ID) references PRODUCT;