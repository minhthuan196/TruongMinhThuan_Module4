INSERT INTO `m4_ss9_borrow_books`.`book` (`id_book`, `author`, `describes`, `name_book`, `quantity`) VALUES ('1', 'Thuận', 'Tình yêu sét đánh', 'Tình yêu vĩnh cữu', '8');
INSERT INTO `m4_ss9_borrow_books`.`book` (`id_book`, `author`, `describes`, `name_book`, `quantity`) VALUES ('2', 'Hữu', 'Tình giữa thầy và trò', 'Tình yêu học đường', '8');
INSERT INTO `m4_ss9_borrow_books`.`book` (`id_book`, `author`, `describes`, `name_book`, `quantity`) VALUES ('3', 'Giang', 'Tình yêu đồng nghiệp', 'Chuyện tình công sở', '8');

INSERT INTO `m4_ss9_borrow_books`.`borrowed_code` (`id_borrow`, `borrow_code`, `status`, `id_book`) VALUES ('1', '12345', b'1', '1');
INSERT INTO `m4_ss9_borrow_books`.`borrowed_code` (`id_borrow`, `borrow_code`, `status`, `id_book`) VALUES ('2', '12346', b'1', '2');
INSERT INTO `m4_ss9_borrow_books`.`borrowed_code` (`id_borrow`, `borrow_code`, `status`, `id_book`) VALUES ('3','12347', b'1', '3');
INSERT INTO `m4_ss9_borrow_books`.`borrowed_code` (`id_borrow`, `borrow_code`, `status`, `id_book`) VALUES ('4', '12122', b'1', '1');
INSERT INTO `m4_ss9_borrow_books`.`borrowed_code` (`id_borrow`, `borrow_code`, `status`, `id_book`) VALUES ('5', '12323', b'1', '2');
