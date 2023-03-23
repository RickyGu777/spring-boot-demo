CREATE TABLE `demo_mp_tablelogic_user`
(
    `id`      bigint NOT NULL AUTO_INCREMENT,
    `account` varchar(64)  DEFAULT NULL,
    `pwd`     varchar(255) DEFAULT NULL,
    `name`    varchar(64)  DEFAULT NULL,
    `deleted` tinyint      DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `u_account` (`account`) USING BTREE
);