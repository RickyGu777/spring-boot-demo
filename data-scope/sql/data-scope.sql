SET NAMES utf8mb4;
SET
FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for demo_data_scope
-- ----------------------------
DROP TABLE IF EXISTS `demo_data_scope`;
CREATE TABLE `demo_data_scope`
(
    `id`        bigint NOT NULL AUTO_INCREMENT,
    `title`     varchar(255) DEFAULT NULL,
    `author`    varchar(255) DEFAULT NULL,
    `borrower`  bigint NULL DEFAULT NULL,
    `create_by` bigint NULL DEFAULT NULL,
    `dept_id`   bigint NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of demo_data_scope
-- ----------------------------
INSERT INTO `demo_data_scope`
VALUES (34, '老人与海', '海明威', 2, 2, 3);

-- ----------------------------
-- Table structure for demo_data_scope_dept
-- ----------------------------
DROP TABLE IF EXISTS `demo_data_scope_dept`;
CREATE TABLE `demo_data_scope_dept`
(
    `dept_id`        bigint NOT NULL AUTO_INCREMENT,
    `dept_name`      varchar(255) DEFAULT NULL,
    `parent_dept_id` bigint NULL DEFAULT NULL,
    `ancestors`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of demo_data_scope_dept
-- ----------------------------
INSERT INTO `demo_data_scope_dept`
VALUES (1, '总务', 0, NULL);
INSERT INTO `demo_data_scope_dept`
VALUES (2, '财务部', 1, '1');
INSERT INTO `demo_data_scope_dept`
VALUES (3, '营销部', 1, '1');
INSERT INTO `demo_data_scope_dept`
VALUES (4, '营销分部', 3, '1,3');

-- ----------------------------
-- Table structure for demo_data_scope_role_dept
-- ----------------------------
DROP TABLE IF EXISTS `demo_data_scope_role_dept`;
CREATE TABLE `demo_data_scope_role_dept`
(
    `id`      bigint NOT NULL AUTO_INCREMENT,
    `role_id` bigint NULL DEFAULT NULL,
    `dept_id` bigint NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB;

-- ----------------------------
-- Records of demo_data_scope_role_dept
-- ----------------------------
INSERT INTO `demo_data_scope_role_dept`
VALUES (1, 2, 2);
INSERT INTO `demo_data_scope_role_dept`
VALUES (2, 2, 3);

SET
FOREIGN_KEY_CHECKS = 1;
