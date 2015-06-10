(ns cijp.fibo)

;; Not again ...

(defn fibo [n]
  (condp = n
    0 1
    1 1
    (+ (fibo (dec n))
       (fibo (- n 2)))))

(fibo 5)

(map fibo (range 1 11))

;; :-)

(defn fb [[a b]] [b (+ a b)])

(fb [2 3])

(defn fb-iter []  (iterate fb [1 1]))

(fb-iter)

(map first (fb-iter))

(defn fibo [n]
  (map first (take n (fb-iter))))

(defn fibo [n]
  (->> (iterate
         (fn [[a b]] [b (+ a b)])
         [1 1])
       (take n)
       (map first)))

(fibo 10)
