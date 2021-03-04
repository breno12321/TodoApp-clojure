(ns todo.lib.components.items.model
  (:require [todo.lib.db.config]
            [korma.core :as korma])
  (:gen-class))

(korma/defentity items)

(defn get-todos
  []
  (korma/select items))

(defn add-todo
  [title description tags done due_date]
  (korma/insert items
          (korma/values {:title title :description description :tags tags :done done :due_date due_date})))

(defn delete-todo
  [id]
  (korma/delete items
          (db/where {:id [= id]})))

(defn update-todo
  [id updatedUser]
  (korma/update items
          (korma/set-fields updatedUser)
          (korma/where {:id [= id]})))

(defn get-todo
  [id]
  (first
    (korma/select items
            (korma/where {:id [= id]}))))

(defn del-todo
  [id]
  (korma/delete items
          (korma/where {:id [= id]})))