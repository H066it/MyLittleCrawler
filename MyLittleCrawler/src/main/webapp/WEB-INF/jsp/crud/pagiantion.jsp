<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<c:choose>
		<c:when test="${keyword == null }">
			<ul class="pagination">
				<li><a href="?page=0">&lt;&lt;</a></li>
				<c:if test="${!pageList.first}">
					<c:choose>
						<c:when test="${pageList.number - 10 < 0 }">
							<li><a href="?page=0">&lt;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="?page=${pageList.number - 10}">&lt;</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>

				<c:if test="${pageList.number < 6 && pageList.totalPages - 1 > 9}">
					<c:forEach begin="0" end="9" var="num">
						<c:choose>
							<c:when test="${num == pageList.number }">
								<li class="active"><a>${num + 1 }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="?page=${num}">${num + 1 }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
				<c:if test="${pageList.number < 6 && pageList.totalPages - 1 <= 9}">
					<c:forEach begin="0" end="${pageList.totalPages - 1 }" var="num">
						<c:choose>
							<c:when test="${num == pageList.number }">
								<li class="active"><a>${num + 1 }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="?page=${num}">${num + 1 }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
				<c:if
					test="${pageList.number > 5 && pageList.number + 4 < pageList.totalPages - 1}">
					<c:forEach begin="${pageList.number - 5}"
						end="${pageList.number + 4 }" var="num">
						<c:choose>
							<c:when test="${num == pageList.number }">
								<li class="active"><a>${num + 1 }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="?page=${num}">${num + 1 }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
				<c:if
					test="${pageList.number > 5 && pageList.number + 4 >= pageList.totalPages - 1}">
					<c:forEach begin="${pageList.number - 5}"
						end="${pageList.totalPages - 1 }" var="num">
						<c:choose>
							<c:when test="${num == pageList.number }">
								<li class="active"><a>${num + 1 }</a></li>
							</c:when>
							<c:otherwise>
								<li><a href="?page=${num}">${num + 1 }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>

				<c:if test="${!pageList.last}">
					<c:choose>
						<c:when test="${pageList.number + 10 > pageList.totalPages - 1 }">
							<li><a href="?page=${pageList.totalPages -1 }">&gt;</a></li>
						</c:when>
						<c:otherwise>
							<li><a href="?page=${pageList.number + 10}">&gt;</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>
				<li><a href="?page=${pageList.totalPages - 1 }">&gt;&gt;</a></li>
			</ul>
		</c:when>

		<c:otherwise>
			<ul class="pagination">
				<li><a
					href="?page=0&searchType=${searchType }&keyword=${keyword }">&lt;&lt;</a></li>
				<c:if test="${!pageList.first}">
					<c:choose>
						<c:when test="${pageList.number - 10 < 0 }">
							<li><a
								href="?page=0&searchType=${searchType }&keyword=${keyword }">&lt;</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="?page=${pageList.number - 10}&searchType=${searchType }&keyword=${keyword }">&lt;</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>

				<c:if test="${pageList.number < 6 && pageList.totalPages - 1 > 9}">
					<c:forEach begin="0" end="9" var="num">
						<c:choose>
							<c:when test="${num == pageList.number }">
								<li class="active"><a>${num + 1 }</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="?page=${num}&searchType=${searchType }&keyword=${keyword }">${num + 1 }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
				<c:if test="${pageList.number < 6 && pageList.totalPages - 1 <= 9}">
					<c:forEach begin="0" end="${pageList.totalPages - 1 }" var="num">
						<c:choose>
							<c:when test="${num == pageList.number }">
								<li class="active"><a>${num + 1 }</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="?page=${num}&searchType=${searchType }&keyword=${keyword }">${num + 1 }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
				<c:if
					test="${pageList.number > 5 && pageList.number + 4 < pageList.totalPages - 1}">
					<c:forEach begin="${pageList.number - 5}"
						end="${pageList.number + 4 }" var="num">
						<c:choose>
							<c:when test="${num == pageList.number }">
								<li class="active"><a>${num + 1 }</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="?page=${num}&searchType=${searchType }&keyword=${keyword }">${num + 1 }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>
				<c:if
					test="${pageList.number > 5 && pageList.number + 4 >= pageList.totalPages - 1}">
					<c:forEach begin="${pageList.number - 5}"
						end="${pageList.totalPages - 1 }" var="num">
						<c:choose>
							<c:when test="${num == pageList.number }">
								<li class="active"><a>${num + 1 }</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="?page=${num}&searchType=${searchType }&keyword=${keyword }">${num + 1 }</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
				</c:if>

				<c:if test="${!pageList.last}">
					<c:choose>
						<c:when test="${pageList.number + 10 > pageList.totalPages - 1 }">
							<li><a
								href="?page=${pageList.totalPages -1 }&searchType=${searchType }&keyword=${keyword }">&gt;</a></li>
						</c:when>
						<c:otherwise>
							<li><a
								href="?page=${pageList.number + 10}&searchType=${searchType }&keyword=${keyword }">&gt;</a></li>
						</c:otherwise>
					</c:choose>
				</c:if>
				<li><a
					href="?page=${pageList.totalPages - 1 }&searchType=${searchType }&keyword=${keyword }">&gt;&gt;</a></li>
			</ul>
		</c:otherwise>
	</c:choose>


</body>
</html>