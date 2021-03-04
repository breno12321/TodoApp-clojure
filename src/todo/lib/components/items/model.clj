(ns todo.lib.components.items.model
  (:require [todo.lib.db.config]
            [korma.core :refer :all])
  (:gen-class))

(defentity items)

(defn get-todos
  []
  (select items))

(defn add-todo
  [title description tags done due_date]
  (insert items
          (values {:title title :description description :tags tags :done done :due_date due_date})))

(defn delete-todo
  [id]
  (delete items
          (where {:id [= id]})))

(defn update-todo
  [id title is-complete]
  (update items
          (set-fields {:title title
                       :is_complete is-complete})
          (where {:id [= id]})))

(defn get-todo
  [id]
  (first
    (select items
            (where {:id [= id]}))))

(defn del-todo
  [id]
  (delete items
          (where {:id [= id]})))