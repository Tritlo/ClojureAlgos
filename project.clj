(defproject mpg.is/clojurealgos "0.0.1-SNAPSHOT"
  :description "Algorithms and data structures in Clojure"
  :url "http://github.com/Tritlo/ClojureAlgos"
  :license {:name "MIT"
            :url "http://opensource.org/licenses/MIT"}
  :dependencies [
                 [org.clojure/clojure "1.7.0"]
                 ]
  :main ^:skip-aot algos.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
