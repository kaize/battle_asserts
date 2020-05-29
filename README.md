[![Build Status](https://travis-ci.org/hexlet-codebattle/battle_asserts.svg?branch=master)](https://travis-ci.org/hexlet-codebattle/battle_asserts)
[![Hexlet chat](http://slack-ru.hexlet.io/badge.svg)](http://slack-ru.hexlet.io)

## Setup for development

- Install [leiningen](http://leiningen.org)

## Contributing

1. Fork it
2. Clone repo (`https://github.com/{your-nickname}/battle_asserts.git`)
3. Create your feature branch (`git checkout -b my-new-feature`)
4. Make changes
5. Run tests (`make test`).
6. Commit your changes (`git commit -am 'Added some feature'`)
7. Push to the branch (`git push origin my-new-feature`)
8. Create new Pull Request
9. Check if Request passed GithubActions

## How to add a new issue

### 1. You have to write the description of the issue with function signature and test-data

A description of issue includes:

- `level` — difficulty of the problem; possible values are `elementary`, `easy`, `medium`, `hard`.
- `description` — detailed description of the problem.
- `signature` — function signature; map with `input` and `output` types types can be nested, see examples in the existed issues.
- `test-data` — data in a specified format which will be used to test solutions. The first element in this list will be displayed as an example to players, so it should clarify and illustrate the problem as much as possible. Do not choose a trivial case for this example.

Example:

```clojure
(ns battle-asserts.issues.array_sum)

(def level :elementary)

(def description "Calculate the sum of array")

(def signature
  {:input  [{:argument-name "array" :type {:name "arr" :nested {:name "integer"}}}]
   :output {:type {:name "integer"}}})

(def test-data
  [{:expected 1
    :arguments [[1]]}
  {:expected 0
    :arguments [[]]}
   {:expected 10
    :arguments [[1 2 3 4]]}])
```

See examples in `src/battle_asserts/issues/*.clj`

### 2. You have to write the correct implementation of the issue and test


An implementation of issue includes:

- `arguments-generator` — arguments generator for the `solution` function;
  generated arguments will be used to test players' solutions.
- `solution` — implemented correct solution.

Example:

```clojure
(ns battle-asserts.issues.array_sum)

(def level :elementary)

(def description "Calculate the sum of array")

(def signature
  {:input  [{:argument-name "array" :type {:name "arr" :nested {:name "integer"}}}]
   :output {:type {:name "integer"}}})

(def test-data
  [{:expected 1
    :arguments [[1]]}
  {:expected 0
    :arguments [[]]}
   {:expected 10
    :arguments [[1 2 3 4]]}])

(defn arguments-generator
  []
  (gen/tuple (gen/list gen/small-integer)
             gen/small-integer
             gen/small-integer))

```
Corresponding tests are in `test/battle_asserts/issues/*.clj`
## Related links

### Leiningen

- http://leiningen.org/#install
- https://github.com/technomancy/leiningen/blob/stable/doc/TUTORIAL.md
