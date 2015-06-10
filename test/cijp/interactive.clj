(ns cijp.interactive)

(defn fancy-api []
  (rand-nth [1 2 3 4 5 6]))

(defn do-stuff []
  (loop []
    (println (fancy-api))
    (Thread/sleep 500)
    (recur)))
