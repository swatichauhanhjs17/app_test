(ns trial.views
  (:require
   [re-frame.core :as re-frame]
   [trial.subs :as subs]
   ))
(defn simple-component []
  [:div
   [:p "I am a component!\n I am introduced for"[:strong "checking"]]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red "] "text."]])

(defn simple-parent []
  [:div
   [:p "I include simple-component."]
   [simple-component]])
(defn hello-component [name]
  [:p "Hello, " name "!"])

(defn say-hello []
  [hello-component "world"])

(defn main-panel []
  (let [name (re-frame/subscribe [::subs/name])]
    [:div
     [:h1 "Hello from " @name]
     [simple-parent]
     ]))
