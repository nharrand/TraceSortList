# TraceSortList
Simple implementation of sorting algorithm and List and their traces.

This java application only sort integer lists.

Usage:
```bash
java -cp target/classes se.kth.sort.App
Usage se.kth.sort.App <ListType> <SortAlgo> i0...in
		ListType in (LinkedList, ArrayList)
		SortAlgo in (Bubble, Insert, Quick)
```

Example:
```bash
java -cp target/classes se.kth.sort.App LinkedList Quick 5 1 3 2 4
1, 2, 3, 4, 5
```

Traces can be found in the archive `trace.tar.xz`. They are captured with [Yajta](https://github.com/castor-software/yajta). They are named folling `<ListImplementation>-<SortingAlgorithm>-<InputSize>.json`

```bash
SMALL="1 5 10 6 8"
MEDIUM="1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40"
LARGE="1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40 1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40 1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40 1 5 10 6 8 85 4 1 2 15 -5 -10 15 20 30 40"
```


Trace format: (First node contains metadata, its children are threads (here there is only one, named `null`)
```json
{
  "name": "Threads",
  "yajta-version": "2.0.0",
  "serialization-version": 0,
  "nodes": 206,
  "branches": 0,
  "threads": 1,
  "children": [
    {
      "name": "null",
      "children": [
        {
          "name": "se.kth.sort.App.main(java.lang.String[])",
          "children": [
            {
              "name": "se.kth.sort.App.main(java.lang.String[])#0",
              "children": []
            },
            {
              "name": "se.kth.sort.App.main(java.lang.String[])#2",
              "children": []
            },
            {
              "name": "se.kth.sort.App.toIntList(java.lang.String[], java.util.function.Supplier)",
              "children": [...]
            },
            {
              "name": "se.kth.sort.App.lambda$main$2(se.kth.sort.list.MyList)",
              "children": [
                {
                  "name": "se.kth.sort.App.lambda$main$2(se.kth.sort.list.MyList)#0",
                  "children": []
                },
                {
                  "name": "se.kth.sort.App.insertSort(se.kth.sort.list.MyList)",
                  "children": [...]
                }
              ]
            }
          ]
        }
      ]
    }
  ]

```
