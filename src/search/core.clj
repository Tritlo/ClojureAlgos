(ns search.core)

(defrecord Point [x y])

(defn indToCoords
  "Takes an index into a 1D representation of a 2D array,
  and returns the 2D coords"
  [index width]
  (->Point (mod index width) (quot index width))
  )

(defn coordsToInd
  [x y width]
  (+ (* y width) x))

(defrecord BFSLoc [index dist])

(defn enqueue [priqueue item prifunc]
  (sort-by prifunc (conj priqueue item)))

(defn dequeue [priqueue]
  (list (last priqueue) (pop priqueue)))

;; (defn BFS
;;   [nStartX nStartY
;;    nTargetX nTargetY
;;    pMap nMapWidth nMapHeight]
;;   (do
;;     (def start (coordsToInd nStartX nStartY))
;;     (def target (coordsToInd nTargetX nTargetY))
;;     (loop [open_set [{:index start :dist 0}] parent (assoc {} start nil) closed_set (hash-set) length 0]
;;       (if (nil? open_set)
;;         -1
;;         (let [deq (dequeue open_set) current (first deq) open_set (second deq)]

;;          )
;;         )
;;       )
;;     )
;;   )
