# PT_Twitter
# Описание:
Разработанное веб-приложение будет площадкой, где пользователи делятся своими постами и просматривают чужие. Коммуникация осуществляется через комментарии и лайки под постами. Также реализованное приложение должно отвечать базовым критериям безопасности: некоторые посты можно помечать как «видимые только для друзей», «видимые только мне». Должно существовать разграничение по уровням доступа: модератор, зарегистрировавшийся пользователь, простой пользователь. Ориентирование по постам может осуществляться через теги, которые можно указать при создании поста.
### Команда разработчиков:
* Вакулин Д.А.
* Филонова В.А.
* Обухова Э.В.
### Сылки:
- [Trello](https://trello.com/202297922533)
- [Miro](https://miro.com/app/board/uXjVOGN-Ch4=/)
- [Приглашение на Miro](https://miro.com/app/board/uXjVOGN-Ch4=/?invite_link_id=962277482334)
- [Техническое задание](https://github.com/pressEm/PT_Twitter/files/8309808/T3_ver19032022.docx)
- [Курсовая работа](https://github.com/pressEm/PT_Twitter/blob/main/KursovayaTwitter.docx)
- [Презентация] (https://github.com/pressEm/PT_Twitter/blob/main/%D0%BF%D1%80%D0%B5%D0%B7%D0%B0.pptx)
- [Swagger](https://app.swaggerhub.com/apis/TP_Twitter/TP_Twitter/1.0.0#/pet/findPetsByStatus)

**Ссылка на сваггер побилась/не сохранилась**, не понимаю, что произошло, но теперь там стандартный petstore, который предоставляет сваггер в виде тестового проекта, а не апи для этого проекта. В связи с чем привожу апи здесь (до тех пор, пока не разберусь и не поправлю сваггер)

1.all posts GET

/posts

2. one post GET

/posts/{id}

3. posts for one tag GET

/posts/tag/{tagid}

4. user profile + latest user posts GET

/users/{id}

5. all user posts GET

/users/{id}/posts

6*. all tags GET

/tags

7. create post POST

/posts

8. create comment POST

/posts/{id}/comment

9. update post UPDATE

/posts/{id}

10. update comment UPDATE

/posts/{id}/comment/{id}

11. all users GET

/users

12. subcriptions

/users/{logged_user_id}/subscriptions

13. subscribers

/users/{logged_user_id}/subscribers

14. login

/login
