(ns cijp.funcdata
  (:require [clojure.pprint :refer [pprint]]
            [clojure.set :as set]))

;; It looks like JSON ...

(def players
  [{:name "Bill"
    :height 183
    :accuracy 7/10
    :team :red
    :skills #{:round-n-round :catapult-shot}
    }
   {:name "Stergios"
    :height 180
    :accuracy 7/10
    :team :red
    :skills #{:go-left}
    }
   {:name "Stelios"
    :height 177
    :accuracy 6/10
    :team :red
    :skills #{:no-fear}
    }
   {:name "Andrew"
    :height 185
    :accuracy 9/10
    :team :blue
    :skills #{:überpass :walk-on-air}
    }
   {:name "George"
    :height 190
    :accuracy 8/10
    :team :blue
    :skills #{:access-denied :rejected}
    }
   {:name "Jordan"
    :height 192
    :accuracy 7/10
    :team :blue
    :skills #{:access-denied :number-23}
    }])

;; First & Rest

(def bill (first players))

(rest players)

;; Keyword as function

(:name bill)

;; Structure as function

(bill :name)

;; Predicates

(defn tall? [player]
  (> (:height player) 185))

(defn uberplayer? [player]
  (> (:height player) 300))

;; Filtering
(pprint (filter tall? players))

;; Calculating averages

(defn avg [nums]
  (let [c (count nums)
        s (reduce + nums)]
    (/ s c)))

(avg [1 2 3 4])

;; Player accuracy average

(avg (map :accuracy players))

;; coerce to float

(float (avg (map :height players)))

;; Same as before but using fewer parentheses

(->> players (map :height) avg float)

;; The same code will be produced

(macroexpand '(->> players (map :height) avg float))

;; Creating Uber Players

(defn player->uberplayer [player]
  (update-in player [:height] * 2))

(player->uberplayer bill)

;; Cool functions

(pprint (sort-by :accuracy > players))

(pprint (group-by :team players))

(pprint (map player->uberplayer players))

;; Using apply

(set/intersection #{1 2 3} #{2 3} #{3})

;; Collecting all the skills

(apply set/union (map :skills players))
