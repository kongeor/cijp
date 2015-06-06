(ns cijp.seqs)

(def v [1 2 3 4])

(def v1 (conj v 5))

(= v v1)

(identical? v v1)

(def v2 (butlast v1))

(= v v2)

;; Find the example

(identical? v v2)

(def l (list 2 3 4))

(def l1 (conj l 1))

(def l2 (rest l1))

(= l l2)

(identical? l l2)

;; Sets and Maps

(def s #{1 2 3 4 5})

(def m {:a 1 :b 2 :c 3})

;; Equality

(println s)

(def s2 (set (range 1 6)))

(= s s2)


