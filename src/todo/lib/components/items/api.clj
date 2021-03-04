(ns todo.lib.components.items.api
  (:require
    [compojure.core :refer :all]
    [clj-time.coerce :as c]
    [todo.lib.components.items.model :as model])
  (:gen-class))

(defn get-todos
  "Retrieve a list of records from todo"
  []
  (model/get-todos))

(defn get-todo
  "Retrieve a record from todo"
  [{id :id}]
  (model/get-todo (Integer/parseInt id)))

(defn del-todo
  "Delete a record from todo"
  [{id :id}]
  (model/del-todo (Integer/parseInt id)))

(defn add-todos
  "Add a record to todo"
  [{ title :title description :description tags :tags done :done due_date :due_date :as record }]    ;; kept this line bc its really cool this notation as for maps
  (model/add-todo
    (:title record)
    (:description record)
    (:tags record)
    (:done record)
    (c/to-sql-time (:due_date record))))