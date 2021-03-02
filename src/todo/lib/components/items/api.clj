(ns todo.lib.components.items.api
  (:require
    [compojure.core :refer :all]
    [todo.lib.components.items.model :as itemsmodel])
  (:gen-class))

(defn get-todos
  "Retrieve a list of records from todo"
  []
  (itemsmodel/get-todos))

(defn get-todo
  "Retrieve a record from todo"
  [{id :id}]
  (itemsmodel/get-todo (Integer/parseInt id)))

(defn add-todos
  "Add a record to todo"
  [{ title :title description :description :as record }]    ;; kept this line bc its really cool this notation as for maps
  (itemsmodel/add-todo (:title record) (:description record)))