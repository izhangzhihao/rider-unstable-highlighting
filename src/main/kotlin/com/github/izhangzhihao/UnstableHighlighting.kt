package com.github.izhangzhihao

import com.intellij.codeInsight.daemon.impl.HighlightVisitor
import com.intellij.codeInsight.daemon.impl.analysis.HighlightInfoHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile

class UnstableHighlighting : HighlightVisitor {
    override fun suitableForFile(file: PsiFile): Boolean {
        if ((file.language.id == "C#" ||
                    file.viewProvider.allFiles.any { it.language.id == "C#" }
                    )
        ) {
            println("............START..................")
            println(file.firstChild.printTree())
            println(".............END...................")
        }
        return true
    }

    override fun visit(p0: PsiElement) {
    }

    override fun analyze(p0: PsiFile, p1: Boolean, p2: HighlightInfoHolder, p3: Runnable): Boolean = true

    override fun clone(): HighlightVisitor = UnstableHighlighting()
}

/**
 * https://github.com/JetBrains/intellij-community/blob/master/plugins/kotlin/core/src/org/jetbrains/kotlin/idea/core/util/PsiTreeUtils.kt
 *
 * This function is intended for debug purposes only. It complements "View PSI Structure" allowing to see PSI tree for arbitrary
 * [PsiElement] in the runtime. Tree has nice and handy format to track its structure. The element itself is marked with '(*)' symbol.
 * @param withMeAsRoot if 'true' the output contains only a subtree with 'this' as a root; otherwise entire tree is provided
 * @param indentStep specifies indentation of child nodes relative the their parens.
 */
fun PsiElement.printTree(withMeAsRoot: Boolean = false, indentStep: Int = 3): String {

    fun PsiElement.printTreeInternal(
        indent: Int = 0,
        result: StringBuilder = StringBuilder(),
        toMark: PsiElement? = this,
        entire: Boolean = true,
        indentStep: Int
    ): String {
        if (entire) return containingFile.printTreeInternal(toMark = toMark, entire = false, indentStep = indentStep)

        val indentSymbols = if (indent > 0) ".".repeat(indent) else ""
        result.append(javaClass.simpleName.prependIndent(indentSymbols))
            .append(" [").append(text).append("]")
            .append(if (this == toMark) " (*)" else "")

        val nextIndent = indent + indentStep
        this.children.forEach {
            result.append("\n")
            it.printTreeInternal(nextIndent, result, toMark, entire = false, indentStep = indentStep)
        }

        return result.toString()
    }

    return printTreeInternal(entire = !withMeAsRoot, indentStep = indentStep)
}