(ns todo.lib.routes
  (:require
    [compojure.core :refer :all]
    [compojure.route :as route]
    [clojure.data.json :as json]
    )
  (:use [todo.lib.components.items.routes :only (items-router)])
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

(def app-routes
  (routes
    (GET "/whoami" [] whoami-route)
    (GET "/" [] echo-route)
    (items-router)
    (route/not-found "<h1>Page Not found my dear friend!</h1>")))

