(ns todo.lib.routes
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.data.json :as json]
    [todo.lib.components.items.routes :as items-routes]
    )
  (:gen-class))

(defn echo-route
  "Echo back the request"
  [req]
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    (-> (str "GET '/' " req))})


(defn whoami-route
  "Who Am I route"
  [_req]
  {
   :status  418
   :headers {"Content-Type" "text/html"}
   :body    "<h1> I'm just an api to learn Clojure and create a simple todolist api</h1>"
   })

(defroutes app-routes
           (GET "/whoami" [] whoami-route)
           (GET "/" [] echo-route)
           (GET "/todos" [] items-routes/get-todos-route)
           (GET "/todos/:id" [] items-routes/get-todo-route)
           (POST "/todos" [] items-routes/add-todos-route)
           (route/not-found "<h1>Page Not found my dear friend!</h1>"))