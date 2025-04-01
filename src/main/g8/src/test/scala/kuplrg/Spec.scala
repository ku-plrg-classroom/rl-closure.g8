package kuplrg

import Implementation.*

class Spec extends SpecBase {

  // Number of trials for `mustEqual`
  private val TRIAL = 1_000

  lazy val dfa1 = DFA(1, "ab", "0", "1")
  lazy val dfa2 = DFA(2, "ab", "3", "2")
  lazy val dfa3 = DFA(2, "ab", "5", "2")
  lazy val dfa4 = DFA(2, "ab", "d", "2")
  lazy val dfa5 = DFA(3, "ab", "51", "4")
  lazy val dfa6 = DFA(3, "01", "k3", "2")
  lazy val dfa7 = DFA(3, "01", "gc", "3")
  lazy val dfa8 = DFA(3, "ab", "5p", "4")
  lazy val dfa9 = DFA(3, "01", "17", "4")
  lazy val dfa10 = DFA(3, "abcd", "4d0k", "1")
  lazy val enfa1 = ENFA(2, "", "0", "2")
  lazy val enfa2 = ENFA(2, "", "2", "2")
  lazy val enfa3 = ENFA(2, "a", "8", "2")
  lazy val enfa4 = ENFA(6, "ab", "ost0183xsrlx05m", "w")
  lazy val enfa5 = ENFA(4, "ab", "fs8wsgw", "8")
  lazy val enfa6 = ENFA(4, "a", "4zthc", "8")
  lazy val enfa7 = ENFA(4, "0", "eebu", "8")
  lazy val enfa8 = ENFA(6, "01", "urgp7qvlhgmm39c", "w")
  lazy val enfa9 = ENFA(8, "ab", "24vjqoqg4suuhnhwz9vdfl6tws3mgy", "3k")
  lazy val enfa10 = ENFA(10, "a", "bti5bb20kvfjhngpzltlwvcxbo5ochxmq", "e8")
  lazy val re1 = RE("a|a|a")
  lazy val re2 = RE("0101010101")
  lazy val re3 = RE("a*b*")
  lazy val re4 = RE("1*01*01*")
  lazy val re5 = RE("(0|1)*000(0|1)*")
  lazy val re6 = RE("(a|<e>)(ba)*|(b|<e>)(ab)*")
  lazy val re7 = RE("aaaa*(bb)*")
  lazy val re8 = RE("(aa)*(ab|<e>)(bb)*")
  lazy val re9 = RE("1*(01*01*01*)*")
  lazy val re10 = RE("(0|1(01*0)*1)*")

  // Tests for complement operation for DFA (`complementDFA`)
  check(complementDFA(dfa1).mustEqual(dfa1.lang.complement, TRIAL))
  check(complementDFA(dfa2).mustEqual(dfa2.lang.complement, TRIAL))
  check(complementDFA(dfa3).mustEqual(dfa3.lang.complement, TRIAL))
  check(complementDFA(dfa4).mustEqual(dfa4.lang.complement, TRIAL))
  check(complementDFA(dfa5).mustEqual(dfa5.lang.complement, TRIAL))
  check(complementDFA(dfa6).mustEqual(dfa6.lang.complement, TRIAL))
  check(complementDFA(dfa7).mustEqual(dfa7.lang.complement, TRIAL))
  check(complementDFA(dfa8).mustEqual(dfa8.lang.complement, TRIAL))
  check(complementDFA(dfa9).mustEqual(dfa9.lang.complement, TRIAL))
  check(complementDFA(dfa10).mustEqual(dfa10.lang.complement, TRIAL))

  // Tests for intersection operation for DFA (`intersectDFA`)
  check(
    intersectDFA(dfa1, dfa2).mustEqual(dfa1.lang intersect dfa2.lang, TRIAL),
  )
  check(
    intersectDFA(dfa1, dfa3).mustEqual(dfa1.lang intersect dfa3.lang, TRIAL),
  )
  check(
    intersectDFA(dfa1, dfa4).mustEqual(dfa1.lang intersect dfa4.lang, TRIAL),
  )
  check(
    intersectDFA(dfa1, dfa5).mustEqual(dfa1.lang intersect dfa5.lang, TRIAL),
  )
  check(
    intersectDFA(dfa2, dfa3).mustEqual(dfa2.lang intersect dfa3.lang, TRIAL),
  )
  check(
    intersectDFA(dfa2, dfa4).mustEqual(dfa2.lang intersect dfa4.lang, TRIAL),
  )
  check(
    intersectDFA(dfa2, dfa5).mustEqual(dfa2.lang intersect dfa5.lang, TRIAL),
  )
  check(
    intersectDFA(dfa3, dfa4).mustEqual(dfa3.lang intersect dfa4.lang, TRIAL),
  )
  check(
    intersectDFA(dfa3, dfa5).mustEqual(dfa3.lang intersect dfa5.lang, TRIAL),
  )
  check(
    intersectDFA(dfa4, dfa5).mustEqual(dfa4.lang intersect dfa5.lang, TRIAL),
  )

  // Tests for reversal operation for ENFA (`reverseENFA`)
  check(reverseENFA(enfa1).mustEqual(enfa1.lang.reverse, TRIAL))
  check(reverseENFA(enfa2).mustEqual(enfa2.lang.reverse, TRIAL))
  check(reverseENFA(enfa3).mustEqual(enfa3.lang.reverse, TRIAL))
  check(reverseENFA(enfa4).mustEqual(enfa4.lang.reverse, TRIAL))
  check(reverseENFA(enfa5).mustEqual(enfa5.lang.reverse, TRIAL))
  check(reverseENFA(enfa6).mustEqual(enfa6.lang.reverse, TRIAL))
  check(reverseENFA(enfa7).mustEqual(enfa7.lang.reverse, TRIAL))
  check(reverseENFA(enfa8).mustEqual(enfa8.lang.reverse, TRIAL))
  check(reverseENFA(enfa9).mustEqual(enfa9.lang.reverse, TRIAL))
  check(reverseENFA(enfa10).mustEqual(enfa10.lang.reverse, TRIAL))

  // Tests for revarsal operation for RE (`reverseRE`)
  check(reverseRE(re1).mustEqual(re1.lang.reverse, TRIAL))
  check(reverseRE(re2).mustEqual(re2.lang.reverse, TRIAL))
  check(reverseRE(re3).mustEqual(re3.lang.reverse, TRIAL))
  check(reverseRE(re4).mustEqual(re4.lang.reverse, TRIAL))
  check(reverseRE(re5).mustEqual(re5.lang.reverse, TRIAL))
  check(reverseRE(re6).mustEqual(re6.lang.reverse, TRIAL))
  check(reverseRE(re7).mustEqual(re7.lang.reverse, TRIAL))
  check(reverseRE(re8).mustEqual(re8.lang.reverse, TRIAL))
  check(reverseRE(re9).mustEqual(re9.lang.reverse, TRIAL))
  check(reverseRE(re10).mustEqual(re10.lang.reverse, TRIAL))

  // Tests for homomorphism operation for RE (`homRE`)
  val h1 = Map('a' -> "010", 'b' -> "")
  val h2 = Map('a' -> "10", 'b' -> "01")
  val h3 = Map('0' -> "a", '1' -> "bb")
  val h4 = Map('0' -> "ab", '1' -> "abb")
  check(homRE(re1, h1).mustEqual(RE("010").lang, TRIAL))
  check(homRE(re2, h3).mustEqual(RE("abbabbabbabbabb").lang, TRIAL))
  check(homRE(re3, h2).mustEqual(RE("(10)*(01)*").lang, TRIAL))
  check(homRE(re4, h4).mustEqual(RE("(abb)*ab(abb)*ab(abb)*").lang, TRIAL))
  check(homRE(re5, h3).mustEqual(RE("(a|bb)*aaa(a|bb)*").lang, TRIAL))
  check(homRE(re6, h1).mustEqual(RE("(010)*").lang, TRIAL))
  check(homRE(re7, h2).mustEqual(RE("(101010)(10)*(0101)*").lang, TRIAL))
  check(homRE(re8, h1).mustEqual(RE("(010010)*(010|<e>)").lang, TRIAL))
  check(homRE(re9, h3).mustEqual(RE("(bb)*(a(bb)*a(bb)*a(bb)*)*").lang, TRIAL))
  check(homRE(re10, h4).mustEqual(RE("(ab|abb(ab(abb)*ab)*abb)*").lang, TRIAL))

  // Tests for inverse homomorphism operation for DFA (`ihomDFA`)
  check(ihomDFA(dfa1, h3).mustEqual(dfa1.lang.ihom(h3), TRIAL))
  check(ihomDFA(dfa2, h4).mustEqual(dfa2.lang.ihom(h4), TRIAL))
  check(ihomDFA(dfa3, h3).mustEqual(dfa3.lang.ihom(h3), TRIAL))
  check(ihomDFA(dfa4, h4).mustEqual(dfa4.lang.ihom(h4), TRIAL))
  check(ihomDFA(dfa5, h3).mustEqual(dfa5.lang.ihom(h3), TRIAL))
  check(ihomDFA(dfa6, h1).mustEqual(dfa6.lang.ihom(h1), TRIAL))
  check(ihomDFA(dfa7, h2).mustEqual(dfa7.lang.ihom(h2), TRIAL))
  check(ihomDFA(dfa8, h3).mustEqual(dfa8.lang.ihom(h3), TRIAL))
  check(ihomDFA(dfa9, h2).mustEqual(dfa9.lang.ihom(h2), TRIAL))
  check(ihomDFA(dfa10, h4).mustEqual(dfa10.lang.ihom(h4), TRIAL))

  /* Write your own tests */
}
