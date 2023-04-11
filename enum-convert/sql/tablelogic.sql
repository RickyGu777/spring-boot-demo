CREATE TABLE `demo_enum_convert_user`
(
    `id`      bigint NOT NULL AUTO_INCREMENT,
    `account` varchar(64)  DEFAULT NULL,
    `pwd`     varchar(255) DEFAULT NULL,
    `name`    varchar(64)  DEFAULT NULL,
    `deleted` tinyint      DEFAULT '0',
    `vip`     tinyint      DEFAULT null,
    PRIMARY KEY (`id`),
    UNIQUE KEY `u_account` (`account`) USING BTREE
);