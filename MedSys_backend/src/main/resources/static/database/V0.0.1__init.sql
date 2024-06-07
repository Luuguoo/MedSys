/*
 Navicat Premium Data Transfer

 Source Server         : yjt
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : 39.107.32.234:3306
 Source Schema         : medsys

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 12/04/2022 20:02:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `aid` int NOT NULL AUTO_INCREMENT,
  `lname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `pwd` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `flag` int NULL DEFAULT 0,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '1', 1);

-- ----------------------------
-- Table structure for applys
-- ----------------------------
DROP TABLE IF EXISTS `applys`;
CREATE TABLE `applys`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `aid` int NULL DEFAULT 0,
  `lname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `xmemo` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `atime` datetime(0) NULL DEFAULT NULL,
  `flag` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `applys_aid`(`aid`) USING BTREE,
  INDEX `applys_lname`(`lname`) USING BTREE,
  CONSTRAINT `applys_aid` FOREIGN KEY (`aid`) REFERENCES `article` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `applys_lname` FOREIGN KEY (`lname`) REFERENCES `users` (`lname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of applys
-- ----------------------------
INSERT INTO `applys` VALUES (1, 3, 'angle', '概述<br />\r\n唐氏筛查是唐氏综合征产前筛选检查的简称。目的是通过化验孕妇的血液，检测母体血清中甲型胎儿蛋白、绒毛促性腺激素和游离雌三醇的浓度，并结合孕妇的年龄、体重、孕周等方面来判断胎儿患先天愚型、神经管缺陷的危险系数。<br />\r\n参考值及临床意义<br />\r\n目前唐筛检查是化验孕妇血液中的甲型胎儿蛋白(AFP)、人类绒毛膜性腺激素(β-hCG)的浓度，并结合孕妇的年龄，运用计算机精密计算出孕妇怀有唐氏症胎儿的危险性。<br />\r\n甲型胎儿蛋白(AFP)一般范围为0.7～2.5MOM(中位数的倍数)，而绒毛膜促性腺激素越高，胎儿患唐氏症的机会越高。另外，还可将甲胎蛋白值、绒毛膜促性腺激素值以及孕妇的年龄、体重、怀孕周数输入电脑，由电脑算出胎儿出现唐氏症的危险性，不同医院使用的标准不一样，如果化验结果标明的几率(如1/100)大于正常参考值几率(如1/275)，则结果为阳性，表示胎儿患病的几率较高，应进一步做羊水穿刺检查或绒毛检查。<br />\r\n1.AFP(甲胎蛋白):AFP是胎儿的一种特异性球蛋白，分子量为64000~70000道尔顿，在妊娠期间可能具有糖蛋白的免疫调节功能，可预防胎儿被母体排斥。AFP在妊娠早期1~2个月由卵黄囊合成，继之主要由胎儿肝脏合成，胎儿消化道也可以合成少量AFP进入胎儿血循环。妊娠6周胎血AFP值快速升高，至妊娠13周达高峰，此后随妊娠进展逐渐下降至足月，羊水中AFP主要来自胎尿，其变化趋势与胎血AFP相似，母血AFP来源于羊水和胎血，但与羊水和胎血变化趋势并不一致。妊娠早期，母血AFP浓度最低，随妊娠进展而逐渐升高，妊娠28-32周时达高峰，以后又下降。怀有先天愚型胎儿的孕妇，其血清AFP水平为正常孕妇的70%，即平均MoM值为0.7~0.8MoM。<br />\r\n2.FreehCGβ(游离-β亚基-促绒毛膜性腺激素):怀有先天愚型胎儿的孕妇，其血清FreehCGβ水平呈强直性升高，平均MoM值为2.3~2.4MoM。hCG是由胎盘细胞合成的人绒毛膜促性腺激素，由a-和b-两个亚单位构成。HCG以两种形式存在，完整的hCG和单独的b-链。两种hCG都有活性，但只有b-单链形式存在的hCG才是测定的特异分子。HCG在受精后就进入母血并快速增殖一直到孕期的第8周，然后缓慢降低浓度直到第18~20周，然后保持稳定。而MOM值是一个比值，即孕妇体内标志物检测值除以相同孕周正常孕妇的中位数值，该值即为MOM。由于产前筛查物的水平随着孕周的增加会有很大变化，因此其值必须转化为中位数的倍数(MOM)表示，使其“标准化”，便于临床判断。<br />\r\n3.正常情况下，人有46个23对染色体，21、18、13三体就是胎儿的第21对、第18对、第13对染色体比正常的2个，多出1个，称为XX三体。其中21三体就是唐氏综合征。染色体异常的发生率随着孕妇年龄的增长而明显增加，如35岁以下的孕妇中染色体异常的发生几率为1:1185，而35岁时则高达1:335，故35岁以上的高龄孕妇需做染色体检查。<br />\r\n检测方法<img src=\"http://localhost:8080/medsys/kindeditor/plugins/emoticons/images/13.gif\" border=\"0\" alt=\"\" /><br />\r\n羊水穿刺术:抽取羊水,培养胎儿脱落在羊水中的细胞,检验细胞的染色体(检验胎儿的21染色体)。抽取羊水:取20ml羊水，风险是可能感染，羊水泄露，流产，流产的可能性(概率1/1000)，培养胎儿脱落在羊水中的细胞，成功率98/100。检验细胞的染色体(检验胎儿的21染色体)，准确率100/100。<br />\r\n<div>\r\n	<br />\r\n</div>', '2021-03-20 01:12:17', '审核通过');
INSERT INTO `applys` VALUES (2, 5, 'hehehe', '概述<br />\r\n气血不足(insufficiency of qi and blood)即中医学中的气虚和血虚。气血不足的结果会导致脏腑功能的减退，引起早衰。气虚即脏腑功能衰退抗病能力差，表现为畏寒肢冷、自汗、头晕耳鸣、精神萎靡、疲倦无力、心悸气短、发育迟缓。血虚可见面色无华萎黄、皮肤干燥、毛发枯萎、指甲干裂、视物昏花、手足麻木、失眠多梦、健忘心悸、精神恍惚。<br />\r\n气血不足属气血同病。气血亏虚则会形体失养，以神疲乏力、气短懒言、面色淡白或萎黄、头晕目眩、唇甲色淡、心悸失眠、舌淡脉弱等为常见证候。</span><br />\r\n 病因病机</span><br />\r\n气血为维护机体正常功能之物质基础，气可以推动血液运行，血可以运载气，气血相互滋生，气虚则血少血少则气虚。久病伤气耗血，而致气血双亏。</span><br />\r\n 临床表现</span><br />\r\n气血不足，体质虚弱，气虚则畏寒肢冷、自汗、头晕耳鸣、疲倦无力、心悸气短、发育迟缓。血虚可见面色无华萎黄、皮肤干燥、毛发枯萎、指甲干裂、视物昏花、手足麻木、失眠多梦、健</span>忘心悸、精神恍惚。气血不足则神疲乏力、气短懒言、面色淡白或萎黄、头晕目眩、唇甲色淡、心悸失眠、女性月经量少、延期或闭经，舌淡脉弱。<br />\r\n诊断<br />\r\n气血双亏之主证:面色萎黄少华，少气懒言，倦怠乏力，头晕目眩，心悸少寐，食少纳呆，舌质淡白，脉濡细。<br />\r\n1.眼睛<br />\r\n看眼睛的色泽和清澈度，眼白的颜色变得浑浊、发黄，有血丝，表明气血不足。⒉皮肤<br />\r\n皮肤白里透着粉红，有光泽、弹性、无皱纹、无斑，代表肺的气血充足。皮肤粗糙，没光泽，发暗、发黄、发白、发青、发红、长斑，表明身体状况不佳、气血不足。<br />\r\n3.头发<br />\r\n头发的生长速度跟肝血相关，如果肝血不足，头发长得慢、头发干枯掉发，头发发黄、发白、开叉，表明气血不足，肝血肾气衰落。<br />\r\n4.牙龈<br />\r\n牙龈与胃肠相关，牙龈萎缩代表气血不足。5.指甲<br />\r\n手指上没有半月形或只有大拇指上有半月形，指甲上出现纵纹，说明体内寒气重、气血两亏，出现透支，是肌体衰老的象征。<br />\r\n<div>\r\n	<br />\r\n</div>', '2021-03-20 01:40:01', '审核通过');

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`  (
  `aid` int NOT NULL AUTO_INCREMENT,
  `tid` int NULL DEFAULT 0,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `photo` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `amemo` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `lname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `atime` datetime(0) NULL DEFAULT NULL,
  `flag` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `flag2` int NULL DEFAULT 0,
  PRIMARY KEY (`aid`) USING BTREE,
  INDEX `article`(`tid`) USING BTREE,
  CONSTRAINT `article` FOREIGN KEY (`tid`) REFERENCES `atype` (`tid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 17 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES (1, 1, '糖尿病', '/upload/1616162533423.jpg', '糖尿病(DM)是一组由多病因引起的胰岛素分泌和(或)利用障碍所导致的以慢性高血糖为特征的代谢性疾病。<br />\r\n糖尿病是常见病、多发病，是严重威胁人类健康的世界性公共卫生问题。<br />\r\n糖尿病是由遗传和环境因素的复合病因引起的临床综合征，但目前其病因和发病机制仍未完全阐明。糖尿病的主要症状是“三多一少”，即多饮、多尿、多食和消瘦，可有皮肤瘙痒（尤其外阴瘙痒)、疲乏无力等。<br />\r\n本病多采用饮食、药物、运动等综合治疗。<br />\r\n糖尿病慢性并发症可遍及全身重要器官，导致大血管病变、微血管病变、神经病变，造成患者生活质量下降。急性并发症不及时处理，严重可危及生命。<br />\r\n<div>\r\n	<br />\r\n</div>', 'admin', '2021-03-19 22:02:14', '审核通过', 1);
INSERT INTO `article` VALUES (2, 1, '手足口病', '/upload/1616162593482.jpg', '什么是手足口病?<br />\r\n·手足口病是由肠道病毒引起的一种常见的传染病。·手足口病多发生于5岁以下儿童。<br />\r\n·手足口病的传染源主要是患者和隐形感染者，常通过呼吸道、消化道(粪-口途径)和密切接触将病毒传染<br />\r\n给其他儿童，引起其患病。<br />\r\n·手足口病分为普通病例和重症病例。普通病例的典型表现为手、足、口腔及臀部等部位出现小疱疹。重<br />\r\n症病例在此基础上出现神经系统、呼吸系统、循环系统等并发症。<br />\r\n·目前尚无针对手足口病的特效抗病毒药物和特异性治疗方法，主要是对症治疗，以缓解症状、减少患者<br />\r\n痛苦。对于重症患者要积极治疗并发症。<br />\r\n·大多数患者愈后极少复发，个别重症患者病情进展快，可危及生命。你需要到哪个科室就诊?<br />\r\n感染科或内科、儿科<br />\r\n为什么会得手足口病?<br />\r\n肠道病毒感染是引起手足口病的主要病因，最常见的是柯萨奇病毒A16型及肠道病毒71型，埃可病毒的某些血清型也可以作为病原体，近年来柯萨奇病毒A6型(CV-A6)和柯萨奇病毒A10型(CV-A10）感染呈现上升趋势。<br />\r\n<div>\r\n	<br />\r\n</div>', 'admin', '2021-03-19 22:03:39', '审核通过', 1);
INSERT INTO `article` VALUES (3, 2, '唐氏筛查', '/upload/1616162656369.jpg', '概述<br />\r\n唐氏筛查是唐氏综合征产前筛选检查的简称。目的是通过化验孕妇的血液，检测母体血清中甲型胎儿蛋白、绒毛促性腺激素和游离雌三醇的浓度，并结合孕妇的年龄、体重、孕周等方面来判断胎儿患先天愚型、神经管缺陷的危险系数。<br />\r\n参考值及临床意义<br />\r\n目前唐筛检查是化验孕妇血液中的甲型胎儿蛋白(AFP)、人类绒毛膜性腺激素(β-hCG)的浓度，并结合孕妇的年龄，运用计算机精密计算出孕妇怀有唐氏症胎儿的危险性。<br />\r\n甲型胎儿蛋白(AFP)一般范围为0.7～2.5MOM(中位数的倍数)，而绒毛膜促性腺激素越高，胎儿患唐氏症的机会越高。另外，还可将甲胎蛋白值、绒毛膜促性腺激素值以及孕妇的年龄、体重、怀孕周数输入电脑，由电脑算出胎儿出现唐氏症的危险性，不同医院使用的标准不一样，如果化验结果标明的几率(如1/100)大于正常参考值几率(如1/275)，则结果为阳性，表示胎儿患病的几率较高，应进一步做羊水穿刺检查或绒毛检查。<br />\r\n1.AFP(甲胎蛋白):AFP是胎儿的一种特异性球蛋白，分子量为64000~70000道尔顿，在妊娠期间可能具有糖蛋白的免疫调节功能，可预防胎儿被母体排斥。AFP在妊娠早期1~2个月由卵黄囊合成，继之主要由胎儿肝脏合成，胎儿消化道也可以合成少量AFP进入胎儿血循环。妊娠6周胎血AFP值快速升高，至妊娠13周达高峰，此后随妊娠进展逐渐下降至足月，羊水中AFP主要来自胎尿，其变化趋势与胎血AFP相似，母血AFP来源于羊水和胎血，但与羊水和胎血变化趋势并不一致。妊娠早期，母血AFP浓度最低，随妊娠进展而逐渐升高，妊娠28-32周时达高峰，以后又下降。怀有先天愚型胎儿的孕妇，其血清AFP水平为正常孕妇的70%，即平均MoM值为0.7~0.8MoM。<br />\r\n2.FreehCGβ(游离-β亚基-促绒毛膜性腺激素):怀有先天愚型胎儿的孕妇，其血清FreehCGβ水平呈强直性升高，平均MoM值为2.3~2.4MoM。hCG是由胎盘细胞合成的人绒毛膜促性腺激素，由a-和b-两个亚单位构成。HCG以两种形式存在，完整的hCG和单独的b-链。两种hCG都有活性，但只有b-单链形式存在的hCG才是测定的特异分子。HCG在受精后就进入母血并快速增殖一直到孕期的第8周，然后缓慢降低浓度直到第18~20周，然后保持稳定。而MOM值是一个比值，即孕妇体内标志物检测值除以相同孕周正常孕妇的中位数值，该值即为MOM。由于产前筛查物的水平随着孕周的增加会有很大变化，因此其值必须转化为中位数的倍数(MOM)表示，使其“标准化”，便于临床判断。<br />\r\n3.正常情况下，人有46个23对染色体，21、18、13三体就是胎儿的第21对、第18对、第13对染色体比正常的2个，多出1个，称为XX三体。其中21三体就是唐氏综合征。染色体异常的发生率随着孕妇年龄的增长而明显增加，如35岁以下的孕妇中染色体异常的发生几率为1:1185，而35岁时则高达1:335，故35岁以上的高龄孕妇需做染色体检查。<br />\r\n检测方法<img src=\"http://localhost:8080/medsys/kindeditor/plugins/emoticons/images/13.gif\" border=\"0\" alt=\"\" /><br />\r\n羊水穿刺术:抽取羊水,培养胎儿脱落在羊水中的细胞,检验细胞的染色体(检验胎儿的21染色体)。抽取羊水:取20ml羊水，风险是可能感染，羊水泄露，流产，流产的可能性(概率1/1000)，培养胎儿脱落在羊水中的细胞，成功率98/100。检验细胞的染色体(检验胎儿的21染色体)，准确率100/100。<br />\r\n<div>\r\n	<br />\r\n</div>', 'admin', '2021-03-19 22:04:34', '审核通过', 1);
INSERT INTO `article` VALUES (4, 3, '免疫治疗', '/upload/1616162726145.jpg', '概述<br />\r\n免疫治疗(immunotherapy)是指针对机体低下或亢进的免疫状态，人为地增强或抑制机体的免疫功能以达到治疗疾病目的的治疗方法。兔疫治疗的方法有很多，适用于多种疾病的治疗。肿瘤的免疫治疗旨在激活人体免疫系统，依靠自身免疫机能杀灭癌细胞和肿瘤组织。与以往的手术、化疗、放疗和靶向治疗不同的是，免疫治疗针对的靶标不是肿瘤细胞和组织，而是人体自身的免疫系统。<br />\r\n分类<br />\r\n免疫治疗有多种分类方法，各类之间又有交叉。<br />\r\n1.根据对机体免疫功能的影响，可分为免疫增强疗法和免疫抑制疗法。⒉.根据治疗的特异性，可分为特异性免疫治疗和非特异性免疫治疗。3.根据免疫制剂的作用特点，可分为主动免疫治疗和被动免疫治疗。4.根据治疗所用的制剂，可分为分子治疗、细胞治疗和免疫调节剂治疗。<br />\r\n制剂<br />\r\n1.分子治疗<br />\r\n分子治疗是指给机体输入分子制剂，以调节机体的特异性免疫应答。(1)）抗体包括多克隆抗体、单克隆抗体和基因工程抗体。<br />\r\n(2)分子疫苗包括重组载体疫苗、合成肽疫苗和DNA疫苗，可作为肿瘤和感染性疾病的治疗性疫苗。(3）细胞因子包括①外源性细胞因子，可用于肿瘤、感染、造血障碍等疾病的治疗。②细胞因子拮抗疗法，通过抑制细胞因子的产生、阻止细胞因子与相应受体结合或阻断结合后的信号转导，来阻止细胞因子发挥生物学效应。<br />\r\n⒉细胞治疗<br />\r\n细胞治疗是指给机体输入细胞制剂，以激活或增强机体的特异性免疫应答。<br />\r\n(1）细胞疫苗包括肿瘤细胞疫苗(如灭活瘤苗、异构瘤苗等)、基因修饰的瘤苗和树突状细胞疫苗等。(2)干细胞移植干细胞具有自我更新能力和多种分化潜能，在适当条件下可被诱导分化为多种细胞组织,如脐带血、外周血、骨髓等。<br />\r\n(3）过继免疫细胞治疗取自体淋巴细胞经体外激活、增殖后回输给患者，直接杀伤肿瘤或激发机体抗肿瘤免;疫效应。<br />\r\n3.免疫调节剂治疗<br />\r\n(1)生物应答调节剂通常对兔疫功能正常者无影响，但对免疫功能异常，特别是免疫功能低下者有促进或调节作用。主要包括①微生物制剂，如卡介苗、短小棒状杆菌、伤寒杆菌脂多糖、链球菌低毒菌株、丙酸杆菌等;②激素，如胸腺素、胸腺生成素等。<br />\r\n(2）免疫抑制剂能抑制机体的免疫功能，常用于自身免疫病的治疗以及防止移植排斥反应的发生。包括①化学合成药物，如糖皮质激素、环磷酰胺、硫唑嘌呤等;②微生物制剂，如环孢素、他克莫司、西罗莫司、吗替麦考酚酯等。<br />\r\n<div>\r\n	<br />\r\n</div>', 'admin', '2021-03-19 22:05:27', '审核通过', 1);
INSERT INTO `article` VALUES (5, 4, '气血不足', '/upload/1616162769785.jpg', '概述<br />\r\n气血不足(insufficiency of qi and blood)即中医学中的气虚和血虚。气血不足的结果会导致脏腑功能的减退，引起早衰。气虚即脏腑功能衰退抗病能力差，表现为畏寒肢冷、自汗、头晕耳鸣、精神萎靡、疲倦无力、心悸气短、发育迟缓。血虚可见面色无华萎黄、皮肤干燥、毛发枯萎、指甲干裂、视物昏花、手足麻木、失眠多梦、健忘心悸、精神恍惚。<br />\r\n气血不足属气血同病。气血亏虚则会形体失养，以神疲乏力、气短懒言、面色淡白或萎黄、头晕目眩、唇甲色淡、心悸失眠、舌淡脉弱等为常见证候。</span><br />\r\n病因病机</span><br />\r\n 气血为维护机体正常功能之物质基础，气可以推动血液运行，血可以运载气，气血相互滋生，气虚则血少血少则气虚。久病伤气耗血，而致气血双亏。</span><br />\r\n临床表现</span><br />\r\n 气血不足，体质虚弱，气虚则畏寒肢冷、自汗、头晕耳鸣、疲倦无力、心悸气短、发育迟缓。血虚可见面色无华萎黄、皮肤干燥、毛发枯萎、指甲干裂、视物昏花、手足麻木、失眠多梦、健</span>忘心悸、精神恍惚。气血不足则神疲乏力、气短懒言、面色淡白或萎黄、头晕目眩、唇甲色淡、心悸失眠、女性月经量少、延期或闭经，舌淡脉弱。<br />\r\n诊断<br />\r\n气血双亏之主证:面色萎黄少华，少气懒言，倦怠乏力，头晕目眩，心悸少寐，食少纳呆，舌质淡白，脉濡细。<br />\r\n1.眼睛<br />\r\n看眼睛的色泽和清澈度，眼白的颜色变得浑浊、发黄，有血丝，表明气血不足。⒉皮肤<br />\r\n皮肤白里透着粉红，有光泽、弹性、无皱纹、无斑，代表肺的气血充足。皮肤粗糙，没光泽，发暗、发黄、发白、发青、发红、长斑，表明身体状况不佳、气血不足。<br />\r\n3.头发<br />\r\n头发的生长速度跟肝血相关，如果肝血不足，头发长得慢、头发干枯掉发，头发发黄、发白、开叉，表明气血不足，肝血肾气衰落。<br />\r\n4.牙龈<br />\r\n牙龈与胃肠相关，牙龈萎缩代表气血不足。5.指甲<br />\r\n手指上没有半月形或只有大拇指上有半月形，指甲上出现纵纹，说明体内寒气重、气血两亏，出现透支，是肌体衰老的象征。', 'admin', '2021-03-19 22:06:11', '审核通过', 1);
INSERT INTO `article` VALUES (6, 1, '风寒感冒', '/upload/1616170165930.jpg', '概述<br />\r\n风寒感冒是因风寒袭表、肺气失宣而引起的感冒，秋冬多发。其症状为恶寒重、发热轻、肢节酸痛、鼻塞声重、咳嗽流涕。治疗上西药、中药皆可，亦可采用食疗。预防措施为注意保暖，加强体育锻炼，提高免疫力。<br />\r\n风寒感冒是风寒之邪外袭所致的感冒。症状可见恶寒重、发热轻、无汗、头痛身痛、鼻塞流清涕、咳嗽吐稀白痰、口不渴或渴喜热饮、昔薄白。<br />\r\n病因<br />\r\n风寒感冒是风寒之邪外袭、肺气失宣所致，其起因通常因劳累，再加上吹风或受凉。风寒感冒通常秋冬发生比较多。<br />\r\n临床表现<br />\r\n1.后脑强痛<br />\r\n即头后部疼痛，连带颈部转动不灵活。⒉怕寒怕风<br />\r\n通常要穿很多衣服或盖大被子才觉得舒服。3.流清涕<br />\r\n清涕，白色或稍微带点黄。如果鼻塞不流涕，喝点热开水，开始流清涕，这也属于风寒感冒;舌无苔或薄白苔，鼻塞声重。喷嚏，流清涕，恶寒，不发热或发热不甚，无汗，周身酸痛，咳嗽痰白质稀，舌苔薄白，脉浮紧。<br />\r\n<div>\r\n	<br />\r\n</div>', 'angle', '2021-03-20 00:09:44', '审核通过', 0);

-- ----------------------------
-- Table structure for atype
-- ----------------------------
DROP TABLE IF EXISTS `atype`;
CREATE TABLE `atype`  (
  `tid` int NOT NULL AUTO_INCREMENT,
  `tname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `is_need_vip` int NULL DEFAULT NULL COMMENT '是否是vip才能发布该类文章 0否1是',
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of atype
-- ----------------------------
INSERT INTO `atype` VALUES (1, '常见疾病', 0);
INSERT INTO `atype` VALUES (2, '常见检查', 1);
INSERT INTO `atype` VALUES (3, '常用治疗', 1);
INSERT INTO `atype` VALUES (4, '常见中医', 0);
INSERT INTO `atype` VALUES (5, '常见预防', 0);
INSERT INTO `atype` VALUES (6, '常用护理', 1);

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `aid` int NULL DEFAULT 0,
  `lname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `addtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `collect`(`aid`) USING BTREE,
  INDEX `collect_lname`(`lname`) USING BTREE,
  CONSTRAINT `collect` FOREIGN KEY (`aid`) REFERENCES `article` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `collect_lname` FOREIGN KEY (`lname`) REFERENCES `users` (`lname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES (1, 5, 'angle', '2021-03-20 00:35:27');
INSERT INTO `collect` VALUES (2, 2, 'angle', '2021-03-20 00:35:54');
INSERT INTO `collect` VALUES (3, 1, 'angle', '2021-03-20 00:36:01');
INSERT INTO `collect` VALUES (4, 5, 'hehehe', '2021-03-20 01:38:55');

-- ----------------------------
-- Table structure for discuss
-- ----------------------------
DROP TABLE IF EXISTS `discuss`;
CREATE TABLE `discuss`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `aid` int NULL DEFAULT 0,
  `lname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `dmemo` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `dtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `discuss_aid`(`aid`) USING BTREE,
  INDEX `discuss_lname`(`lname`) USING BTREE,
  CONSTRAINT `discuss_aid` FOREIGN KEY (`aid`) REFERENCES `article` (`aid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `discuss_lname` FOREIGN KEY (`lname`) REFERENCES `users` (`lname`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of discuss
-- ----------------------------
INSERT INTO `discuss` VALUES (1, 2, 'angle', '手足口病这个有点恐怖呀手足口病这个有点恐怖呀手足口病这个有点恐怖呀手足口病这个有点恐怖呀手足口病这个有点恐怖呀手足口病这个有点恐怖呀手足口病这个有点恐怖呀手足口病这个有点恐怖呀', '2021-03-20 00:46:45');
INSERT INTO `discuss` VALUES (3, 2, 'hehehe', '手足口传染性太强了手足口传染性太强了手足口传染性太强了手足口传染性太强了', '2021-03-20 01:39:40');
INSERT INTO `discuss` VALUES (5, 2, 'hehehe', '太可怕了', '2022-02-18 18:08:22');

-- ----------------------------
-- Table structure for flink
-- ----------------------------
DROP TABLE IF EXISTS `flink`;
CREATE TABLE `flink`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `http` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of flink
-- ----------------------------
INSERT INTO `flink` VALUES (1, '央广网健康', 'http://health.cnr.cn/');
INSERT INTO `flink` VALUES (2, '中国经济网医药频道', 'http://www.ce.cn/');
INSERT INTO `flink` VALUES (3, '新浪医药新闻', 'https://med.sina.com/');
INSERT INTO `flink` VALUES (4, '凤凰网健康', 'http://ihealth.ifeng.com/');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `detail` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `addtime` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '保健食品能放心吃吗？', '医生在线网据现代快报网报道，现代快报讯（记者徐岑卢河燕文/摄）褪黑素、葡萄籽胶囊、维生素片……你在靠哪种“药”续命？年轻人逐渐加入养生大军，成为保健食品的购买主力。而海淘、网购又是年轻人樶常用的购物方式。保健食品安不安全？网购是否靠谱？保健食品功效如何？1月15日，南京市玄武区市场监管局发布保健食品专项抽检报告。SWISSE、汤臣倍健等知名品牌8大类38批次一一检测，结果怎么说？现代快报记者帮你画重点。<br />\r\n<div>\r\n	<img src=\"http://img.51daifu.com/image/202012/20201221/20201221160144_36358.jpg\" alt=\"\" width=\"380\" height=\"236\" title=\"\" /> \r\n</div>\r\n年底的“双十一”“双十二”购物狂潮中，保健食品销量高居榜单前列。尤其值得注意的是，助眠类、减肥类、抗衰老、美容类等保健食品，成为年轻人的心头好。为此，玄武区市场监管局联合玄武区消协采取线上线下同时抽样的形式，对8大类38批次的保健食品进行了检测。<br />\r\n<br />\r\n现代快报记者了解到，检测品牌包括SWISSE、汤臣倍健、GNC、碧生源、养生堂等知名品牌，共涉及减肥、美容、助眠、抗氧化、补钙、增加免疫力、补充维生素、补充蛋白质8大类功效，全是年轻人樶关心的。<br />\r\n<br />\r\n检测结果显示，同款、同类产品线上线下比对，质量基本一致。网络流行的通过外观判断是否正 品的说法，存在偏差。比如SWISSE钙片，检测结果显示质量基本一致，但是其外包装在颜色、图标上的确有较大差异。大家可以放心购买。不过，需要提醒大家的是，此次检测的产品都是从线上官方旗舰店、正规海外旗舰店、正规海淘平台等购买，都是合法正规渠道。因此，建议消费者通过正规渠道选购商品，对不明来路的海外代购、微商要审慎选择，尤其是价格远低于官方产品的，更要慎重。<br />\r\n<br />\r\n正规渠道购买安全性符合要求<br />\r\n而大家樶关心的，莫过于保健食品到底有没有效果。此次检测特地对减肥、助眠、美容等功效性成分项目进行了检测。结果显示，8大类产品中有4类产品功效成分都达到产品标注参考值，质量较好。比如，美容类产品的主要功效性成分之一为生育酚，这是维生素E的水解产物。合理摄入生育酚，可以祛除黄褐斑和减少黑色素产生，此次检测2批次产品都达到产品标注值。<br />\r\n<br />\r\n另外4类产品在检测中共有5批次产品没有达到产品外包装上对标注参考值，包括抗氧化类产品、补钙类产品、增加免疫力产品，以及补充蛋白质类产品。“比如一些国外进口产品，可能检测的方法和国外的方法不一致，方法的偏差也会导致结果的偏差。南京海关动植物与食品检测中心部门主管栾军告诉记者。<br />\r\n<br />\r\n差别樶大的是，购买自网络“草珊瑚保健品专营店”的施元牌乳清蛋白粉。经检测，该样品蛋白质和膳食纤维都没有达到标注值。蛋白质含量相差较大，标注为18g/100g，实测3.94g/100g。玄武区市场监管局食品科科长罗亚玲介绍，该局将对此批次产品提高关注，对线下实体店开展排查，如发现同批次产品将实施监督抽检，一旦检测值未达标准，将依法处置。此外，购买自网络“博昱采保健品专营店”的康恩贝牌辅酶Q10咀嚼片，检测后，辅酶Q10实测值为6.43g/100g，与其标注值7.2g/100g差距虽然不大，但依然提出风险警示。<br />\r\n<br />\r\n此外，安全性指标也10 0%符合要求。这主要是指保健食品内没有非法添加，也没有重金属污染物。“消费者在正规药店、官网等购买的保健品，安全性符合要求。”栾军说。<br />\r\n<br />\r\n部分“超标”作为平时补充含量低<br />\r\n值得注意的是，部分产品在检测过程中还发现“超标”现象。比如，汤臣倍健牌左旋肉碱茶多酚荷叶片中的总黄酮含量为0.08g/100g，比0.01g/100g的该产品标注值高8倍。<br />\r\n<br />\r\n而碧生源牌左旋肉碱茶多酚胶囊的企业标准无此功效性成分的标注要求，产品也未标注总黄酮含量，其实测值为3.9g/100g。“虽然总黄酮是有益物质，作为平时普通补充，它的含量很低。但是建议企业完善标准，明确标注，与实际检测值匹配，有利于消费者正确评估产品功效及进行选择。”<br />\r\n<br />\r\n保健食品不是药品，不能一味追求摄入量<br />\r\n那么问题来了，在此次检测过程中都没有问题的保健食品，是不是都可以放心吃了？吃保健食品的确有功效？对此，罗亚玲举例，生育酚（维生素E）为脂溶性维生素，容易存储在体内，不易排出体外，合理摄入有利健康，但大量食用和滥用的情况下，反而有潜在毒性。因此，保健食品中的功效成分及含量虽然很重要，但也不能一味追求含量和摄入量，应当根据自身健康情况、日常饮食习惯等进行补充。<br />\r\n<br />\r\n此外，保健食品不是药品。保健食品说到底还是一种食品，没有治疗疾病的功效，不可以替代药品。虽然我们此次检测中没有发现非法添加的行为，但是消费者如果在使用保健食品的过程中，发现功效好得“出奇”，且可能伴有各种不良反应，影响到身体健康，应立即警惕，并及时向所在地的市场监管部门反映。（来源：现代快报）', '2021-03-19 21:43:32');
INSERT INTO `news` VALUES (3, '六成老年住院患者有营养问题', '北京协和医院临床营养科主任于康表示：“国内外大量研究证实，特医食品有助于提高患者抵抗力，减少营养相关并发症，同时可缩短患者的住院时间、节省治疗费用，从而改善患者的临床结局。更为重要的是，将特医食品纳入临床治疗能让患者生活得更有质量、更有尊严。”<br />\r\n<br />\r\n特殊医学用途配方食品是介于普通食品和药品之间的一类特殊状态下食用的食品，它不具备针对某种疾病的治疗效果，但能改善患者的营养状况，提高患者的整体健康水平，为疾病的治疗和恢复健康提供良好的基础。<br />\r\n<br />\r\n特医食品 早以肠内营养产品形式存在，与静脉营养相比，特医食品无需通过穿刺或插管，有效地减少了感染、术后并发症等情况的发生。<br />\r\n<br />\r\n研究表明我国住院患者存在营养不良的比例居高不下，而营养不良将导致患者机体对手术或治疗的耐受性下降，易发生感染等并发症，影响预后。<br />\r\n<br />\r\n在临床上，特医食品不仅是治疗辅助手段，还是一种治疗手段。有数据表明，一些患者治疗期间营养不良，导致病症加重或出现并发症的概率高很多。将人体所需的各类营养素均衡搭配，如蛋白质、碳水化合物、脂肪、维生素、矿物质等，可以作为单一营养来源长期单独食用。', '2021-03-19 21:51:36');
INSERT INTO `news` VALUES (6, '袋泡茶茶包别扔了 十种妙方总有一款能用上', '很多人喜欢用袋泡茶，花茶、绿茶、养生茶......简单、干净、携带方便，可是你知道吗？被你扔掉的那个茶包也是个好东西呢，不信？下面提供十个常用的小妙方，不妨来试试。\n  消除你的眼睛\n     晚上没睡好，眼睛浮肿，可以使两个含咖啡因的茶包敷在眼睛上。将它们浸泡在温水中，就像要泡一杯茶一样，然后将它们放在冰箱中几分钟以使其冷却。在每只眼睛上放一袋，5分钟，可以缓解浮肿，并使眼睛附近的血管收缩。       \n   改善皮肤状况\n     如果您偶然发现一种有毒的番木鳖，并且正在处理瘙痒，疼痛的皮疹，那么进行一次红茶浴可能会帮助减轻炎症和舒缓皮肤。研究表明，用红茶制成的湿敷料可以很好地治疗其他皮肤疾病，例如面部皮炎，可引起瘙痒性皮疹。', '2022-02-16 16:04:53');

-- ----------------------------
-- Table structure for qualification
-- ----------------------------
DROP TABLE IF EXISTS `qualification`;
CREATE TABLE `qualification`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `lname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `pic` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int NULL DEFAULT NULL COMMENT '0:正在审核 1:审核成功  2:审核失败',
  `isDel` int NULL DEFAULT NULL COMMENT '0未删除 1 删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qualification
-- ----------------------------
INSERT INTO `qualification` VALUES (2, 'hehehe', '/upload/6ccfbd796b0f4d4f8431ed715fd1480d.png', 2, 1);
INSERT INTO `qualification` VALUES (3, 'hehehe', '/upload/b38872b3e1c84aa89b94bda5bd633bc5.png', 2, 1);
INSERT INTO `qualification` VALUES (4, 'hehehe', '/upload/63b99b49d809484facaef570cfe53df9.png', 1, 1);
INSERT INTO `qualification` VALUES (5, '111', '/upload/287299dfffed4dac91d3be60e65630d1.png', 2, 1);
INSERT INTO `qualification` VALUES (6, '111', '/upload/f09cc10a90c54ef5b3e38c9aea94f244.png', 2, 1);

-- ----------------------------
-- Table structure for records
-- ----------------------------
DROP TABLE IF EXISTS `records`;
CREATE TABLE `records`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `rname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of records
-- ----------------------------
INSERT INTO `records` VALUES (1, '手足口病');
INSERT INTO `records` VALUES (2, '糖尿病');
INSERT INTO `records` VALUES (3, '糖尿病');
INSERT INTO `records` VALUES (4, '感冒');
INSERT INTO `records` VALUES (5, '糖尿病');
INSERT INTO `records` VALUES (6, '手足口病');
INSERT INTO `records` VALUES (7, '手足口病');
INSERT INTO `records` VALUES (8, '手足口病');
INSERT INTO `records` VALUES (9, '手足口病');
INSERT INTO `records` VALUES (10, '唐氏筛查');
INSERT INTO `records` VALUES (11, '糖尿病');
INSERT INTO `records` VALUES (12, '唐氏筛查');
INSERT INTO `records` VALUES (13, '手足口病');
INSERT INTO `records` VALUES (14, '感冒');
INSERT INTO `records` VALUES (17, '唐氏筛查');
INSERT INTO `records` VALUES (18, '中国');
INSERT INTO `records` VALUES (21, '唐氏筛查');
INSERT INTO `records` VALUES (22, '感冒');
INSERT INTO `records` VALUES (23, '中国');
INSERT INTO `records` VALUES (24, '中国');
INSERT INTO `records` VALUES (25, '中国');
INSERT INTO `records` VALUES (26, '中国');
INSERT INTO `records` VALUES (27, '中国');
INSERT INTO `records` VALUES (28, '中国');
INSERT INTO `records` VALUES (29, '手足口病');
INSERT INTO `records` VALUES (30, '中国');
INSERT INTO `records` VALUES (31, '中国');
INSERT INTO `records` VALUES (32, '手足口病');
INSERT INTO `records` VALUES (33, '糖尿病');
INSERT INTO `records` VALUES (34, '中国');
INSERT INTO `records` VALUES (35, '中国');
INSERT INTO `records` VALUES (36, '泡茶');
INSERT INTO `records` VALUES (37, '感冒');
INSERT INTO `records` VALUES (62, '手足口病');
INSERT INTO `records` VALUES (63, '手足口病');
INSERT INTO `records` VALUES (64, '唐氏筛查');
INSERT INTO `records` VALUES (65, '手足口病');
INSERT INTO `records` VALUES (66, '中国');
INSERT INTO `records` VALUES (67, '手足口病');
INSERT INTO `records` VALUES (68, '手足口病');
INSERT INTO `records` VALUES (69, '手足口病');
INSERT INTO `records` VALUES (70, '糖尿病');
INSERT INTO `records` VALUES (71, '手足口病');
INSERT INTO `records` VALUES (72, '中国');
INSERT INTO `records` VALUES (73, '手足口病');
INSERT INTO `records` VALUES (74, '中国');
INSERT INTO `records` VALUES (75, '手足口病');
INSERT INTO `records` VALUES (76, '手足口病');
INSERT INTO `records` VALUES (77, '手足口病');
INSERT INTO `records` VALUES (78, '手足口病');
INSERT INTO `records` VALUES (79, '中国');
INSERT INTO `records` VALUES (80, '手足口病');
INSERT INTO `records` VALUES (81, '中国');
INSERT INTO `records` VALUES (83, '手足口病');
INSERT INTO `records` VALUES (86, '手足口病');
INSERT INTO `records` VALUES (87, '唐氏筛查');
INSERT INTO `records` VALUES (88, '唐氏筛查');
INSERT INTO `records` VALUES (90, '手足口病');
INSERT INTO `records` VALUES (91, '手足口病');
INSERT INTO `records` VALUES (92, '新冠病毒');
INSERT INTO `records` VALUES (93, '唐氏筛查');
INSERT INTO `records` VALUES (94, '');
INSERT INTO `records` VALUES (95, '唐氏筛查');
INSERT INTO `records` VALUES (96, '手足口病');
INSERT INTO `records` VALUES (97, '');
INSERT INTO `records` VALUES (98, '手足口病');
INSERT INTO `records` VALUES (99, '手足口病');
INSERT INTO `records` VALUES (100, '手足口病');
INSERT INTO `records` VALUES (101, '中国');
INSERT INTO `records` VALUES (102, '唐氏筛查');
INSERT INTO `records` VALUES (103, '手足口病');
INSERT INTO `records` VALUES (104, '的');
INSERT INTO `records` VALUES (105, '手足口病');
INSERT INTO `records` VALUES (106, '手足口病');
INSERT INTO `records` VALUES (107, '手足口病');
INSERT INTO `records` VALUES (108, '');
INSERT INTO `records` VALUES (109, '');
INSERT INTO `records` VALUES (110, '');
INSERT INTO `records` VALUES (111, '');
INSERT INTO `records` VALUES (112, '');
INSERT INTO `records` VALUES (113, '');
INSERT INTO `records` VALUES (114, '');
INSERT INTO `records` VALUES (115, '');
INSERT INTO `records` VALUES (116, '');
INSERT INTO `records` VALUES (117, '');
INSERT INTO `records` VALUES (118, '');
INSERT INTO `records` VALUES (119, '');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `lname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `tel` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `pic` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '',
  `regdate` datetime(0) NULL DEFAULT NULL,
  `level` int NOT NULL COMMENT '用户级别（0：普通用户）（1：资深用户）',
  PRIMARY KEY (`lname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('111', '111111', '111', '男', '11111111111', '/upload/ba3871c98c4b4b509f49a1c5c59d4caa.png', '2022-03-18 10:49:30', 0);
INSERT INTO `users` VALUES ('angle', '123456', '王小萌', '女', '13829910009', '/upload/1616160570392.jpg', '2021-03-19 21:29:32', 0);
INSERT INTO `users` VALUES ('hehehe', '123456', '王刚', '男', '13122223333', '/upload/1616175521431.jpg', '2021-03-20 01:38:43', 1);

SET FOREIGN_KEY_CHECKS = 1;
