(ns cijp.core
  (:require [clojure.pprint :only :pprint]))

(def players
  [{:name "Bill"
    :height 183
    :accuracy 5/10
    :skills #{:roben}
    }
   {:name "Stelios"
    :height 177
    :accuracy 4/10
    :skills #{:no-fear}
    }
   {:name "Andrew"
    :height 185
    :accuracy 7/10
    :skills #{:überpass :walk-on-air}
    }
   {:name "George"
    :height 190
    :accuracy 6/10
    :skills #{:access-denied :rejected}
    }
   {:name "Jordan"
    :height 192
    :accuracy 5/10
    :skills #{:access-denied :number-23}
    }])

(defn tall? [player]
  (> (:height player) 185))

(pprint (filter tall? players))

(defn avg [nums]
  (let [c (count nums)
        s (reduce + nums)]
    (/ s c)))

(defn player->uberplayer [player]
  (update-in player [:height] * 2))

(pprint (map player->uberplayer players))

(float (avg (map :height players)))

(take 5 (iterate inc 1))

(range 10)

(defn fibo [[a b]] [b (+ a b)])

(map second (take 1 (drop 100000 (iterate fibo [1N 1]))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
