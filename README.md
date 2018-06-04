# Каталог новых автомобилей
### Возможности:
1. На сайте существует перечень новых автомобилей. Для удобства поиска имеется страница выбора бренда и модели.
2. Бренды и автомобили выводятся в виде карточек с названием и изображением. На странице автомобиля выводятся его большая фотография и характеристики.
3. Авторизованные пользователи могут смотреть автомобили и добавлять в список избранных. Неавторизованные пользователи только смотреть.
4. Администратор и модератор сайта могут добавлять, изменять или удалять необходимые бренды, модели и автомобили. Для этого имеется удобный редактор. Для изменения данных используется кнопка с всплывающим PupUp окном.
5. Доступ к редактору ограничивается с помощью фильтра и доступен только администратору и модератору.
6. Все изображения сайта хранятся в "C:\car_catalog\image". Для изменения пути сохранения изображений имеется константа. При загрузке изображения с формы сайта изображению присваивается сгенерированный номер в диапазоне целочисленного типа данных long.
7. На сайте реализована возможность выбора языка (Русский, Английский).

### Особенности:
1. Используется база данных MySQL.
2. Работа с базой данных производится через Hibernateframework.
3. В качестве контроллера используется DispatcherServlet из SpringMVC.
4. Фильтр для преобразования кодировки в UTF-8 заимствуется из SpringMVC.
5. При исключительных ситуациях, которые не могут быть обработаны программой, данные об ошибке записываются в log файл с помощью Log4j.
6. Для предотвращения взлома аккаунта и кражи паролей из базы данных реализованы следующие функции:
	* При регистрации пользователя пароль соединяется с "солью". "Соль" генерируется для каждого пользователя и сохраняется в базе данных. Далее высчитывается hash по технологии SHA-256.
	* Полученный hash шифруется по технологии AES. Ключ и вектор хранятся локально на компьютере (сервере) и загружаются в JVM при первом запуске приложения.
	* Полученный зашифрованный hash сохраняется в поле password базы данных.

### Использованные в проекте технологии:
* JavaServlet.
* SpringIoC.
* SpringMVC.
* Hibernateframework.
* Bootstrap 4.
* jQuery.
* Ajax.
* Log4j.
* SHA-256, AES.

### Дополнительно реализовать:
* Возможность добавления автомобиля в список избранных.
* Добавить поиск по автомобилям.
* Сделать возможность сравнения выбранных пользователем автомобилей.

### Схема базы данных:
 
![GitHubLogo](https://github.com/pavel3423/car_catalog/blob/master/src/main/sqlScript/Diagram.png)