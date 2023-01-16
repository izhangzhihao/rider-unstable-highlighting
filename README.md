# step to re-produce

## run the project

./gradlew runide

## tail the idea log

```bash
tail -f build/idea-sandbox/system/log/idea.log
```

## open sample project with below code

```C#
namespace MyNamespace;

public class s
{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}
```


## get logs from the console

```log
............START..................
CSharpFileImpl [namespace MyNamespace;

public class s
{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}]
...CSharpNamespaceDeclarationImpl [namespace MyNamespace;

public class s
{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}] (*)
......LeafPsiElement [namespace]
......PsiWhiteSpaceImpl [ ]
......LeafPsiElement [MyNamespace]
......LeafPsiElement [;]
......PsiWhiteSpaceImpl [
]
......PsiWhiteSpaceImpl [
]
......CSharpNamespaceBodyImpl [public class s
{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}]
.........CSharpDummyDeclaration [public class s
{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}]
............LeafPsiElement [public]
............PsiWhiteSpaceImpl [ ]
............LeafPsiElement [class]
............PsiWhiteSpaceImpl [ ]
............CSharpDeclarationIdentifier [s]
...............LeafPsiElement [s]
............PsiWhiteSpaceImpl [
]
............CSharpDummyBlockImpl [{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}]
...............LeafPsiElement [{]
...............PsiWhiteSpaceImpl [
]
...............PsiWhiteSpaceImpl [    ]
...............CSharpMethodDeclaration [public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }]
..................LeafPsiElement [public]
..................PsiWhiteSpaceImpl [ ]
..................CSharpDeclarationIdentifier [void]
.....................LeafPsiElement [void]
..................PsiWhiteSpaceImpl [ ]
..................CSharpDeclarationIdentifier [test]
.....................LeafPsiElement [test]
..................CSharpDummyNodeImpl [()]
.....................LeafPsiElement [(]
.....................LeafPsiElement [)]
..................PsiWhiteSpaceImpl [
]
..................PsiWhiteSpaceImpl [    ]
..................CSharpDummyBlockImpl [{
        for (int i = 0; i < 5; ++i)
        {
        }
    }]
.....................LeafPsiElement [{]
.....................PsiWhiteSpaceImpl [
]
.....................PsiWhiteSpaceImpl [        ]
.....................CSharpDummyNodeImpl [for (int i = 0; i < 5; ++i)
        {
        }]
........................LeafPsiElement [for]
........................PsiWhiteSpaceImpl [ ]
........................CSharpDummyNodeImpl [(int i = 0; i < 5; ++i)]
...........................LeafPsiElement [(]
...........................CSharpVarDeclarationStatement [int i = 0;]
..............................CSharpDeclarationIdentifier [int]
.................................LeafPsiElement [int]
..............................PsiWhiteSpaceImpl [ ]
..............................CSharpDeclarationIdentifier [i]
.................................LeafPsiElement [i]
..............................PsiWhiteSpaceImpl [ ]
..............................LeafPsiElement [=]
..............................PsiWhiteSpaceImpl [ ]
..............................LeafPsiElement [0]
..............................LeafPsiElement [;]
...........................PsiWhiteSpaceImpl [ ]
...........................CSharpStatementImpl [i < 5;]
..............................LeafPsiElement [i]
..............................PsiWhiteSpaceImpl [ ]
..............................LeafPsiElement [<]
..............................PsiWhiteSpaceImpl [ ]
..............................LeafPsiElement [5]
..............................LeafPsiElement [;]
...........................PsiWhiteSpaceImpl [ ]
...........................LeafPsiElement [++]
...........................LeafPsiElement [i]
...........................LeafPsiElement [)]
........................PsiWhiteSpaceImpl [
]
........................PsiWhiteSpaceImpl [        ]
........................CSharpDummyBlockImpl [{
        }]
...........................LeafPsiElement [{]
...........................PsiWhiteSpaceImpl [
]
...........................PsiWhiteSpaceImpl [        ]
...........................LeafPsiElement [}]
.....................PsiWhiteSpaceImpl [
]
.....................PsiWhiteSpaceImpl [    ]
.....................LeafPsiElement [}]
...............PsiWhiteSpaceImpl [
]
...............LeafPsiElement [}]
.............END...................
```

## edit file, like add new line after line 7 and delete the new line again

now we should expect same PSI tree after editing,

but found this in console:


```log
............START..................
CSharpFileImpl [namespace MyNamespace;

public class s
{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}]
...CSharpNamespaceDeclarationImpl [namespace MyNamespace;

public class s
{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}] (*)
......LeafPsiElement [namespace]
......PsiWhiteSpaceImpl [ ]
......LeafPsiElement [MyNamespace]
......LeafPsiElement [;]
......PsiWhiteSpaceImpl [
]
......PsiWhiteSpaceImpl [
]
......CSharpNamespaceBodyImpl [public class s
{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}]
.........CSharpDummyDeclaration [public class s
{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}]
............LeafPsiElement [public]
............PsiWhiteSpaceImpl [ ]
............LeafPsiElement [class]
............PsiWhiteSpaceImpl [ ]
............CSharpDeclarationIdentifier [s]
...............LeafPsiElement [s]
............PsiWhiteSpaceImpl [
]
............CSharpDummyBlockImpl [{
    public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }
}]
...............LeafPsiElement [{]
...............PsiWhiteSpaceImpl [
]
...............PsiWhiteSpaceImpl [    ]
...............CSharpMethodDeclaration [public void test()
    {
        for (int i = 0; i < 5; ++i)
        {
        }
    }]
..................LeafPsiElement [public]
..................PsiWhiteSpaceImpl [ ]
..................CSharpDeclarationIdentifier [void]
.....................LeafPsiElement [void]
..................PsiWhiteSpaceImpl [ ]
..................CSharpDeclarationIdentifier [test]
.....................LeafPsiElement [test]
..................CSharpDummyNodeImpl [()]
.....................LeafPsiElement [(]
.....................LeafPsiElement [)]
..................PsiWhiteSpaceImpl [
]
..................PsiWhiteSpaceImpl [    ]
..................CSharpDummyBlockImpl [{
        for (int i = 0; i < 5; ++i)
        {
        }
    }]
.....................LeafPsiElement [{]
.....................PsiWhiteSpaceImpl [
]
.....................PsiWhiteSpaceImpl [        ]
.....................CSharpDummyNodeImpl [for (int i = 0;]
........................LeafPsiElement [for]
........................PsiWhiteSpaceImpl [ ]
........................LeafPsiElement [(]
........................LeafPsiElement [int]
........................PsiWhiteSpaceImpl [ ]
........................LeafPsiElement [i]
........................PsiWhiteSpaceImpl [ ]
........................LeafPsiElement [=]
........................PsiWhiteSpaceImpl [ ]
........................LeafPsiElement [0]
........................LeafPsiElement [;]
.....................PsiWhiteSpaceImpl [ ]
.....................CSharpDummyNodeImpl [i < 5;]
........................LeafPsiElement [i]
........................PsiWhiteSpaceImpl [ ]
........................LeafPsiElement [<]
........................PsiWhiteSpaceImpl [ ]
........................LeafPsiElement [5]
........................LeafPsiElement [;]
.....................PsiWhiteSpaceImpl [ ]
.....................CSharpDummyNodeImpl [++i)]
........................LeafPsiElement [++]
........................LeafPsiElement [i]
........................LeafPsiElement [)]
.....................PsiWhiteSpaceImpl [
]
.....................PsiWhiteSpaceImpl [        ]
.....................CSharpDummyBlockImpl [{
        }]
........................LeafPsiElement [{]
........................PsiWhiteSpaceImpl [
]
........................PsiWhiteSpaceImpl [        ]
........................LeafPsiElement [}]
.....................PsiWhiteSpaceImpl [
]
.....................PsiWhiteSpaceImpl [    ]
.....................LeafPsiElement [}]
...............PsiWhiteSpaceImpl [
]
...............LeafPsiElement [}]
.............END...................
```

## please compare them using https://www.diffchecker.com/text-compare/