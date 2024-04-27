DROP TABLE IF EXISTS `audit`;
create table audit
(
    id              varchar(64)  not null
        primary key,
    customer_id     varchar(64)  not null,
    transcation_ref varchar(100) not null,
    instrument_id   varchar(64)  not null,
    instrument_name varchar(100) not null,
    trade_type      varchar(4)   not null,
    audit_date      datetime     not null
);
insert into audit (id, customer_id, transcation_ref, instrument_id, instrument_name, trade_type, audit_date) values ('wewee', 'aaa', 'ref1', 'ins1', 'insname1', 'BUY', '2024-04-27 13:02:55');
insert into audit (id, customer_id, transcation_ref, instrument_id, instrument_name, trade_type, audit_date) values ('wewee2', 'aaa', 'ref2', 'ins2', 'insname2', 'SELL', '2024-04-27 13:22:55');
insert into audit (id, customer_id, transcation_ref, instrument_id, instrument_name, trade_type, audit_date) values ('wewee3', 'aaa', 'ref3', 'ins3', 'insname3', 'BUY', '2024-04-27 13:23:55');
insert into audit (id, customer_id, transcation_ref, instrument_id, instrument_name, trade_type, audit_date) values ('wewee4', 'aaa', 'ref4', 'ins4', 'insname4', 'SELL', '2024-04-27 13:24:55');

DROP TABLE IF EXISTS `instruments`;
create table instruments
(
    instrument_id    varchar(64)    not null
        primary key,
    instrument_name  varchar(100)   not null,
    instrument_value decimal(10, 2) not null,
    instrument_type  varchar(20)    not null
);

insert into instruments (instrument_id, instrument_name, instrument_value, instrument_type) values ('ddvvv', 'ABC1', 12331.11, 'Bond');
insert into instruments (instrument_id, instrument_name, instrument_value, instrument_type) values ('ddvvv2', 'ABC2', 222.11, 'Bond');
insert into instruments (instrument_id, instrument_name, instrument_value, instrument_type) values ('ddvvv3', 'ABC3', 33333.11, 'Bond');

