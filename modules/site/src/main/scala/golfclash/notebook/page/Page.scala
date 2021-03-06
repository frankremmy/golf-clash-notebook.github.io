/*
 * MIT License
 *
 * Copyright (c) 2018 golf-clash-notebook
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package golfclash.notebook.page

import scala.scalajs.js

sealed abstract class Page(val baseUrl: String, val init: Option[js.Function0[_]] = None)
    extends Product
    with Serializable

object Page {

  case object Balls       extends Page("^/balls/$", Some(balls.init))
  case object ClubRanker  extends Page("^/tools/clubranker/$", Some(clubranker.init))
  case object Clubs       extends Page("^/clubs/", Some(clubs.init))
  case object Courses     extends Page("^/courses/", Some(courses.init))
  case object CrowdCaddy  extends Page("^/crowdcaddy/", Some(crowdcaddy.init))
  case object FAQ         extends Page("^/faq/$", Some(faq.init))
  case object HoleRanker  extends Page("^/tools/holeranker/$", Some(holeranker.init))
  case object Home        extends Page("^/$", Some(home.init))
  case object Tournaments extends Page("^/tournaments/", Some(tournaments.init))
  case object Tours       extends Page("^/tours/")
  case object WindChartCreator
      extends Page("^/tools/windchartcreator/$", Some(windchartcreator.init))

  private val All =
    List(
      Balls,
      ClubRanker,
      Clubs,
      Courses,
      CrowdCaddy,
      FAQ,
      HoleRanker,
      Home,
      Tournaments,
      Tours,
      WindChartCreator
    )

  def forUrlPath(path: String): Option[Page] = {
    All.find { page =>
      (page.baseUrl.r).findFirstIn(path).isDefined
    }
  }
}
