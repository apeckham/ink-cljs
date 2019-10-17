(ns tui.core
  (:require
   ["react" :refer [React Component]]
   ["ink" :refer [render Color Box]]
   [reagent.core :as r]))

(defonce c (r/atom 0))

(defn hello-world
  []
  [:> Box {:flexGrow 1} [:> Box {:width "50%"} [:> Color {:red true} (str "red: " @c)]]
   [:> Box {:width "50%"} [:> Color {:yellow true} (str "yellow: " @c)]]])

(defn -main [] (js/setInterval #(swap! c inc) 100) (render (r/as-component [hello-world])))